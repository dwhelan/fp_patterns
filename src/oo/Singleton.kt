package oo

class Singleton {
    companion object {
        val instance by lazy { Singleton() }
    }

    // ... useful methods here
}
