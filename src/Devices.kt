 class Door {
     var open = false
         private set
     var message = ""
         private set

     fun open() { open = true }
     fun close() { open = false }
     fun greet(message: String) { this.message = message }
 }

 class Light {
     var on = false
         private set

     fun on() { on = true }
     fun off() { on = false }
 }
