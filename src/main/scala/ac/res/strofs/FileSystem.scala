package ac.res.strofs

import java.nio.file.Path

import slick.jdbc.JdbcBackend.Database
import slick.jdbc.SQLiteProfile.api._

import scala.concurrent.Future

class FileSystem(val rootPath: Path) {
  val db = Database.forURL(url = s"jdbc:sqlite:${rootPath.resolve("strofs.sqlite").normalize.toUri.getPath}")

  val file = TableQuery[File]

  def create(): Future[Unit] = {
    db.run(
      DBIO.seq(
        file.schema.createIfNotExists
      )
    )
  }
}
