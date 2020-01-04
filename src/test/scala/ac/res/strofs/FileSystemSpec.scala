package ac.res.strofs

import java.nio.file.Files

import org.scalatest.funsuite.AnyFunSuite

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class FileSystemSpec extends AnyFunSuite {
  test("create database") {
    val tmp = Files.createTempDirectory("strofs")
    Files.createDirectories(tmp)
    val fs = new FileSystem(tmp)
    Await.result(fs.create(), Duration.Inf)
    println(tmp)
  }
}
