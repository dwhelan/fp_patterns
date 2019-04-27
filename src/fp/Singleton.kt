package fp

class Singleton {
    // ... useful methods here
}

val singleton: () -> () -> Singleton = {
    { Singleton() }
}
