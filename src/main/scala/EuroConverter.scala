import EuroConverter._
import Printer._
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object EuroConverter {
  def props(printerActor: ActorRef): Props = Props(new EuroConverter(printerActor))
  case class euro2bitcoin(euro: BigDecimal)
  case class euro2dollar(euro: BigDecimal)
}

class EuroConverter(printerActor: ActorRef) extends Actor with ActorLogging {

  def receive = {
    case euro2bitcoin(euro) =>
      val bitcoin = euro / 5551
      printerActor ! PrintCurrency(bitcoin)
    case euro2dollar(euro) =>
      val dollar = euro * 1.18
      printerActor ! PrintCurrency(dollar)
  }
}