package fp

import Light
import Door

typealias Command = (
    () -> Any
)

val turnOn: (Light) -> Command = {
    light ->  { light.on() }
}

val turnOff: (Light) -> Command = {
    light ->  { light.off() }
}

val open: (Door) -> Command = {
    door -> { door.open() }
}

val close: (Door) -> Command = {
    door -> { door.close() }
}

val greet: (Door, String) -> Command = {
    door, message -> { door.greet(message)}
}

val sequencer: (List<Command>) -> Command = {
    commands -> { commands.forEach { command -> command() } }
}
