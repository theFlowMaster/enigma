
fun main () {
    var alphabet = "abcdefghijklmnopqrstuvwxyz"

    var reflector1 = "rvqtdxozhewpuimcabgjfskynl"
    var reflector2 = "qsuhmzrdpabklnijytcefgoxwv"
    var reflector3 = "ubkvaxgjswhtdeoclyiqrfnzpm"

    var plain = "ty"
    var cipher = ""
    var state = 0

    fun reflector(myChar:Char):Char{
        return alphabet[alphabet.length-alphabet.indexOf(myChar)-1]
    }

    fun process(myChar:Char):Char{
        var myChar1 = reflector1[alphabet.indexOf(myChar)]
        var myChar2 = reflector2[alphabet.indexOf(myChar1)]
        var myChar3 = reflector3[alphabet.indexOf(myChar2)]

        var reflected = reflector(myChar3)

        myChar3 = alphabet[reflector3.indexOf(reflected)]
        myChar2 = alphabet[reflector2.indexOf(myChar3)]
        myChar1 = alphabet[reflector1.indexOf(myChar2)]

        return myChar1
    }

    fun rotate_rotors(){
        reflector1 = reflector1.removeRange(0,1) + reflector1[0]
        if (state % 26 == 0){
            reflector2 = reflector2.removeRange(0,1) + reflector2[0]
        }
        if(state % 676 == 0){
            reflector3 = reflector3.removeRange(0,1) + reflector3[0]
        }
    }
    for(myChar in plain){
        state += 1
        cipher += process(myChar)
        rotate_rotors()
    }

    print(cipher)
}
