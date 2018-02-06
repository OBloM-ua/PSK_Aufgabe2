import akka.actor.{Actor, ActorLogging, Props}
import Printer._

object Printer {
  def props: Props = Props[Printer]
  final case class Print(message: String)
  final case class PrintCurrency(currency: BigDecimal)
}

class Printer extends Actor with ActorLogging {

  def receive = {
    case PrintCurrency(currency: BigDecimal) => println(s"$currency")
    case Print(message: String) => println(s"$message")
  }
}