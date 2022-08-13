package playground

import java.time.LocalDate
import java.time.temporal.ChronoUnit

object Sandbox extends App{

  val minDate = LocalDate.of(2022,4,1)
  val maxDate = LocalDate.of(2022, 7, 31)

  def yearMonthsRange(minDate: LocalDate, maxDate: LocalDate = LocalDate.now) = {
    val months = ChronoUnit.MONTHS.between(minDate, maxDate).toInt
    val interval = 0.to(months).map(
      x => {
        val date = minDate.plus(x, ChronoUnit.MONTHS)
        (date.getYear, date.getMonth.getValue)
      }
    )
    interval
  }

  val test = yearMonthsRange(minDate, maxDate)

  val test2 = 0.to(4)
  println(test2.map(_ + 4))
  println(test)


}
