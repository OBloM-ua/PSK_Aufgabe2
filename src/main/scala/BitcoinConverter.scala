import BitcoinConverter._
import Printer._
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object BitcoinConverter {
  def props(printerActor: ActorRef): Props = Props(new BitcoinConverter(printerActor))
  case class bitcoin2euro(euro: BigDecimal)
  case class bitcoin2dollar(euro: BigDecimal)
  case class bitcoin2text(text: String)
}

class BitcoinConverter(printerActor: ActorRef) extends Actor with ActorLogging {

  def receive = {
    case bitcoin2euro(bitcoin) =>
      val euro = bitcoin * 5551
      printerActor ! PrintCurrency(euro)
    case bitcoin2dollar(bitcoin) =>
      val dollar = bitcoin * 6500
      println(dollar)
    case bitcoin2text(bitcoin) =>
      printerActor ! Print(bitcoin + " hallo String")
  }
}