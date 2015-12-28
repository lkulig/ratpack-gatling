
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.scenario.Simulation
import scala.concurrent.duration._

class RatpackSimulation extends Simulation{

 val getUrl = "http://localhost:5050/api/simple"

  val getRequest = scenario("Ratpack GET").during(20 seconds) {
    val request = http("post asset").get(getUrl)
    exec(request)
  }

  setUp(getRequest.inject(rampUsers(1000) over (1 seconds)))

}
