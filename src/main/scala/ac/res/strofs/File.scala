package ac.res.strofs

import java.sql.Blob

import slick.jdbc.SQLiteProfile.api._

object File {
  object CompressionType {
    val Raw = 1
    val LZ4 = 2
  }
}

class File(tag: Tag) extends Table[(Long, String, Long, Long, Long, Array[Byte], Int, Option[Blob])](tag, "File") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def ctime = column[Long]("ctime")
  def mtime = column[Long]("mtime")
  def size = column[Long]("size")
  def sha224 = column[Array[Byte]]("sha224")
  def compressionType = column[Int]("compression_type")
  def content = column[Option[Blob]]("content")
  def * = (id, name, ctime, mtime, size, sha224, compressionType, content)
}
