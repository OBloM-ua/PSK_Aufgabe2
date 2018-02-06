import DollarConverter._
import Printer._
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object DollarConverter {
  def props(printerActor: ActorRef): Props = Props(new DollarConverter(printerActor))
  case class dollar2bitcoin(euro: BigDecimal)
  case class dollar2euro(euro: BigDecimal)
}

class DollarConverter(printerActor: ActorRef) extends Actor with ActorLogging {

  def receive = {
    case dollar2bitcoin(dollar) =>
      val bitcoin = dollar / 6500
      printerActor ! PrintCurrency(bitcoin)
    case dollar2euro(dollar) =>
      val euro = dollar * 0.85
      printerActor ! PrintCurrency(euro)
  }
}