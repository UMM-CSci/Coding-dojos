class Shifter {
	def shift(String str, int x) {
		String toReturn = ""
		x = x % 26
		if (x < 0){
			x = x + 26
		}
		for (int i = 0; i < str.length(); i++) {
			char tempChar = str.charAt(i)
			char a = 'a'
			char z = 'z'
			char A = 'A'
			char Z = 'Z'
			toReturn += convertChar(a, z, tempChar, x)
			toReturn += convertChar(A, Z, tempChar, x)
		}

		return toReturn
	}
	
	def convertChar(char c1, char c2, char temp, int x) {
		def toReturn = ""
		if (temp >= c1 && temp <= c2){
			if(temp + x > c2){
				toReturn = toReturn + ((char) temp + x - 26)
			} else {
				toReturn = toReturn + ((char) temp + x)
			}
		}
		return toReturn
	}
}

