package com.microWorkflow

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

trait Base {
  def asString: String
}

case class IntSub(i: Int) extends Base {
  def asString: String = s"state = $i"
}

case class StringSub(s: String) extends Base {
  def asString: String = s"state = $s"
}

case class SymbolSub(y: Symbol) extends Base {
  def asString: String = s"state = $y"
}

@State(Scope.Benchmark)
class Microbenchmark {

  //@Setup(Level.Trial)
  val all: Array[Base] = Array.tabulate(5000){ case n => n % 3 match {
    case 0 => IntSub(n)
    case 1 => StringSub(n.toString)
    case 2 => SymbolSub(Symbol(n.toString))
  }}


  @Benchmark
  def round(blackhole: Blackhole): Unit = {
    blackhole.consume(all.map (_.asString.nonEmpty))
  }

  @Benchmark
  def curly(blackhole: Blackhole): Unit = {
    blackhole.consume(all.map {_.asString.nonEmpty})
  }

  @Benchmark
  def partialFunction(blackhole: Blackhole): Unit = {
    blackhole.consume(all.map { case each => each.asString.nonEmpty })
  }
}

