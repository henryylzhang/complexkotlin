println("UW Complex Kotlin homework")

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15)
// use map to return a list with "", "FIZZ" or "BUZZ" as necessary
// use fold to compress the array of strings down into a single string
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//

/* Part 1 */
// fizzbuzz function
fun fizzbuzz (num: Int): String {
    var ret: String = ""
    if (num % 3 == 0) {
        ret += "FIZZ"
    }
    if (num % 5 == 0) {
        ret += "BUZZ"
    }
    return ret
}


val numRange: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

var fb: List<String> = numRange.map({fizzbuzz(it)})

val mapFoldResults: String = fb.fold("", {first, second -> first + second})

/* End Part 1 */


/* Part 2 */
// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}

// call process() with message "FOO" and a block that returns "BAR"
val r1 = process("FOO", {"BAR"}) 

// call process() with message "FOO" and a block that upper-cases
// r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"
val r2_message = "wooga"
val r2 = process("FOO", {r2_message.toUpperCase().repeat(3)}) 

/* End Part 2 */


/* Part 3 */
/* Extra Credit
 * 
 * 1. Seneca the Younger was a Roman philosopher and advisor to Emperor Nero. He lived in the first century CE.
 * 2. His works are commonly associated with the school of Stoicism. 
 * 3. Stoicism is philosophy that focuses on the control of self and one's emotions - it stresses using 
 * logic to reason through things that upset us rather than just reacting. 
 * s
 * End Extra Credit */

// write an enum-based state machine between talking and thinking
enum class Philosopher { 
	THINKING {
		override fun signal() = TALKING
		override fun toString(): String {
			return "Deep thoughts...."
		}
	},
	
	TALKING {
		override fun signal() = THINKING
		override fun toString(): String {
			return "Allow me to suggest an idea..."
		}
	};

	abstract fun signal(): Philosopher
}

/* End Part 3 */


/* Part 4 */
// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message
class Command(val prompt: String) {
	operator fun invoke(message: String): String {
		return prompt + message
	}
}

/* End Part 4 */



// ================================
println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")

println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")

var seneca = Philosopher.THINKING
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
print("Seneca, think! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Deep thoughts....") "." else "!")
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")

print("Command tests: ")
print(if (Command("")("") == "") "." else "!")
print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
println("")



