package jimmy.tutorial

import scala.slick.driver.PostgresDriver.simple._

// Tutorial testing.
// Tutorial inspired by http://queirozf.com/entries/scala-slick-simple-example-on-connecting-to-a-postgresql-database

object Main {

  // this is a class that represents the table I've created in the database
  class Users(tag: Tag) extends Table[(Int, String)](tag, "users") {
    def id = column[Int]("id")
    def username = column[String]("username")
    def * = (id, username)
  }

  def main(args: Array[String]): Unit = {

    val dbName = "cheong1"
    val host = "localhost"
    val username = "postgres"
    val password = "postgres"
    val connectionUrl = s"jdbc:postgresql://$host/${dbName}?user=$username&password=$password"
    val postgresDriver = "org.postgresql.Driver"

    Database.forURL(connectionUrl, postgresDriver) withSession {
      implicit session =>
        val users = TableQuery[Users]

        // SELECT * FROM users
        users.list foreach { row =>
          println("user with id " + row._1 + " has username " + row._2)
        }

        // SELECT * FROM users WHERE username='john'
        users.filter(_.username === "john").list foreach { row =>
          println("user whose username is 'john' has id "+row._1 )
        }
    }
  }
}
