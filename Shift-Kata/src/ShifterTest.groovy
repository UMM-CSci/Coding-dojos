class ShifterTest extends spock.lang.Specification {
	def "testShift"() {
		Shifter shifter = new Shifter()
		expect:
		shifter.shift(string, num) == finalString

		where:
		string     | num  |	finalString  
		"abc"      | 0    |	"abc"
		"abc"      | 1    | "bcd"
		"a.b.c."   | 0    | "abc"
		"abc"      | 2    | "cde"
		"ABC"      | 1    | "BCD"
		"BCD"      | 2    | "DEF"
		"ABcd"     | 1    | "BCde"
		"XYZ"      | 1    | "YZA"
		"XyC.1b"   | 3    | "AbFe"
		"abc"      | 26   | "abc"
		"abc"	   | 52   | "abc"
		"aB c"     | 27   | "bCd"
		"abc"      | 26 * 100 + 1 | "bcd"
		"abc"      | -1   | "zab"
		"abc"      | -27  | "zab"
	}
}