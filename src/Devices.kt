 class Door {
     var message = ""
         private set

     fun greet(message: String) { this.message = message }
 }

 class Light {
     var on = false
         private set

     fun on() { on = true }
 }
