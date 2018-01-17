package edu.knoldus

import org.apache.log4j.Logger.getLogger

abstract class Payment {

  class Paytm() extends Payment

  class Freecharge() extends Payment

  class Netbanking() extends Payment

  class Cardpayment() extends Payment

  class Cash() extends Payment

 }

object PaymentSeeker extends Payment with App {
 val log = getLogger(this.getClass)

 def calculatePayment(pay: Payment, amount: Double): Double = {
  pay match {
   case first : Paytm => {
    (0.02 * amount) + amount
   }
   case second : Freecharge => {
    (0.02 * amount) + amount
   }
   case third : Netbanking => 5 + amount
   case fourth : Cardpayment => 1.5 + amount
   case fifth : Cash => amount
   case _ => 0.0
  }
 }

 val money = 82.4
 val pay = new Paytm {}
 val charge = new Freecharge {}
 val card= new Cardpayment {}
 val notes = new Cash {}
 val net = new Netbanking
 log.debug(calculatePayment(pay, money) + " \n")
 log.debug(calculatePayment(charge, money) + " \n")
 log.debug(calculatePayment(card, money) + " \n")
 log.debug(calculatePayment(notes, money) + " \n")
 log.debug(calculatePayment(net, money) + " \n")


 /*
class Payment{
 def acceptPayment(operations: String, amount: Double): Double = {
 operations match {
   case "paytm" => {(0.02 * amount) + amount}
   case "freecharge" => {(0.02 * amount) + amount}
   case "netbanking" => {5 + amount}
   case "cardpayment" => {1.5 + amount}
   case "cash" => amount
   case _ => 0.0
  }
 }
}*/
}
