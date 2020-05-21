package example

import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.reflect.Reflector

object Hello extends App {

  implicit val formats = DefaultFormats 
  
  case class Friendliness(level: String)
  

  case class Person(firstName: String,
                    lastName: String,
                    friendliness: Friendliness = Friendliness("high"),
                    age: Int = 40
                   ) {
    def this(unrelated: Int, weird: Boolean) = this("John", "Doe", Friendliness("not much"))                   
 }

  val k = classOf[Person]
  val klass = Reflector.scalaTypeOf(k)
  val descriptor = Reflector.describe(klass).asInstanceOf[reflect.ClassDescriptor]
  System.out.println(descriptor.constructors.map(_.params.length.toString).mkString(","))


  val parsed = parse("""{"firstName": "Stephen", "lastName": "Falken"}""")
  val person = org.json4s.Extraction.extractOpt[Person](parsed).get
 
  System.out.println(s"Greetings, Professor ${person.lastName}")
}
