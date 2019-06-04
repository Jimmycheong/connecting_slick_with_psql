package jimmy.tutorial

import jimmy.tutorial.schema.Users
import slick.jdbc.PostgresProfile.api._
import slick.util.Logging

import scala.concurrent.Await
import scala.concurrent.duration.Duration


object Main extends App with Logging {

  logger.info("Starting program")

  val db = Database.forConfig("psqldb")
  val users = TableQuery[Users]

  try {
    import scala.concurrent.ExecutionContext.Implicits.global

    val insertUsersAction: DBIO[Option[Int]] = users ++= Seq(
      (5, "Tom"),
      (6, "Jerry")
    )

    val insertAndPrintAction: DBIO[Unit] = insertUsersAction.map { userInsertResults =>
      userInsertResults foreach { numRows =>
        println(s"Number of rows inserted: $numRows")
      }
    }

    logger.info("Executing action plan")
    val resultFuture = db.run(insertAndPrintAction)

    Await.result(resultFuture, Duration.Inf)
    logger.info("Program completed")
  } finally db.close

}
