package fp

import Light
import Door

typealias Command = (
    () -> Unit
)

val turnOn: (Light) -> Command = {
    light -> { light.on() }
}

val greet: (Door, String) -> Command = {
    door, message -> { door.greet(message) }
}

val sequencer: (List<Command>) -> Command = {
    commands -> { commands.forEach { command -> command() } }
}
