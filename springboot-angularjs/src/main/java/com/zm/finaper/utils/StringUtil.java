package com.zm.finaper.utils;


import java.io.Reader;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
   Class with methods to make life easier when working with Strings.
   Methods can be added to this class on an as-needed basic

   @author Werner Koster, 11/09/2002
 */

public class StringUtil {


    public static final String EOL = System.getProperty("line.separator");
    public static final String TAB = "\t";
    public static final String EMPTY_STRING = "".intern();
    public static final String PLUS_SYMBOL = "+";
    public static final String MINUS_SYMBOL = "-";
    public static final char NBSP = '\u00A0'; // Non-breaking space
    public static final char SPACE_CHAR = ' ';
    public static final char ZERO_CHAR = '0';
    public static final String DOLLAR_STRING = "$";
    public static final String SPACE_STRING = " ";
    private static final String QUOTE_DOUBLE = "\"";
    public static final String QUOTE_SINGLE = "'";
    public static final char PERIOD_CHAR = '.';
    public static final String SEMI_COLON = ";";
    public static final String COLON = ":";
    public static final String FORWARD_SLASH = "/";
    public static final String BACK_SLASH = "\\";
    public static final String UNDERSCORE = "_";
    public static final String COMMA = ",";
    public static final char COMMA_CHAR = ',';

    public static final int NOT_FOUND_INDEX = -1;

    /** A Pattern to match a lower case character */
    public static Pattern LOWERCASE_CHAR_REGEXP = Pattern.compile("[a-z]", Pattern.MULTILINE);

    /** a Pattern to match an uppercase character */
    private static Pattern UPPERCASE_CHAR_REGEXP = Pattern.compile("[A-Z]", Pattern.MULTILINE);

    /** A Pattern to check if a string is entirely one or more spaces */
    public static Pattern SPACES_REGEXP = Pattern.compile("^[ ]+$", Pattern.MULTILINE);

    public static final String SINGLE_SPACE_REGEXP = "\\s";
    
    //--------------------------------------------------------------------------

    public static boolean startsWith(String str, String prefix) {
        return str != null && str.startsWith(prefix);
    }

    /**
     * Does the string contain a lower case character?
     * @param string the string to test
     * @return true if the string contains a lower case character.
     */
    public static boolean containsLowerCaseChar(String string) {
        return matches(string, LOWERCASE_CHAR_REGEXP);
    }

    /**
     * Does the string contain an upper case character?
     * @param string the string to test
     * @return true if the string contains an upper case character.
     */
    public static boolean containsUpperCaseChar(String string) {
        return matches(string, UPPERCASE_CHAR_REGEXP);
    }

    /**
     * Does the string consist of spaces?
     * @param string the string to test
     * @return true if the string contains only spaces
     */
    public static boolean isSpaces(String string) {
        return matches(string, SPACES_REGEXP);
    }

    /**
     * is there a match for the pattern in the string?
     * @param string the String
     * @param pattern the Pattern
     * @return true if there is a match for the pattern in the string.
     */
    public static boolean matches(String string, Pattern pattern) {
        return pattern.matcher(string).find();
    }

    /**
     * Compare two strings to see if they are equal, ignoring the case.
     * If they are both null they will be considered equal.
     *
     * This method is useful in determining whether or not a String variable
     * which may contain nulls has been changed, and case changes are not
     * significant.
     *
     * @see #isEqualCaseSensitive
     *
     * @param s1
     * @param s2
     * @return true if the two strings are considered to be equal
     */
    public static boolean isEqual(String s1, String s2) {
        boolean equal;

        if (s1 == null && s2 == null) {
            equal = true;

        } else if (s1 != null) {
            equal = s1.equalsIgnoreCase(s2);

        } else { // if (s2 != null) {
            equal = s2.equalsIgnoreCase(s1);
        }

        return equal;
    }

    /**
     * Compare two strings to see if they are equal using a case sensitive
     * comparison.  If they are both null they will be considered equal.
     *
     * This method is useful in determining whether or not a String variable
     * which may contain nulls has been changed, and case is important.
     *
     * @see #isEqual
     *
     * @param s1
     * @param s2
     * @return true if the two strings are considered to be equal
     */
    public static boolean isEqualCaseSensitive(String s1, String s2) {
        boolean equal;

        if (s1 == null && s2 == null) {
            equal = true;

        } else if (s1 != null) {
            equal = s1.equals(s2);

        } else { // if (s2 != null) {
            equal = s2.equals(s1);
        }

        return equal;
    }

    /**
     * This method inherits its name from the oracle function, with the same
     * behaviour.
     *
     * This method should be called when working with strings that may be null.
     * It saves adding null checks in the programs, by doing the check
     * here and returning a ""
     * @param inString contains the target-string.  It will be tested for null.
     */
    public static String nvl(String inString) {
        return (inString == null) ? EMPTY_STRING : inString;
    }

    /**
     * This method inherits its name from the oracle function, with the same
     * behaviour.
     *
     * This method should be called when working with strings that may be null.
     * It saves adding null checks in the programs, by doing the check
     * here and returning a String as specified by the caller.
     * @param inString contains the target-string.  It will be tested for null.
     * @param nullReplacementString contains the string to replace the target-string with (if it is null)
     */
    public static String nvl(String inString, String nullReplacementString) {
        return (inString == null) ? nullReplacementString : inString;
    }

    /**
     * This method is like a toString method which returns an empty string
     * if the object is null
     */
    public static String nvl(Object aObject) {
        return (aObject != null) ? aObject.toString() : EMPTY_STRING ;
    }

    /**
     * This method inherits its name from the oracle function, with the same
     * behaviour.
     *
     * This method should be called when working with Doubles that may be null.
     * It saves adding null checks in the programs, by doing the check
     * here and returning 0
     * @param inDouble contains the target-Double. It will be tested for null.
     */
    public static double nvl(Double inDouble) {
        return (inDouble == null) ? 0 : inDouble;
    }

    /**
     * Determines whether the specified string only contains alphanumeric
     * characters.
     * @param string the string to inspect.
     * @return <code>true</code> if and only if the string is a non-empty string
     *         containing alphanumeric characters only.
     */
    public static boolean isAlphanumeric(String string) {
        if (string == null || string.length() < 1) {
            return false;
        }
        char[] charArray = string.toCharArray();
        for (int i = charArray.length-1; i >= 0; i--) {
            if (!Character.isLetterOrDigit(charArray[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether the specified string only contains digits
     * @param string the string to inspect.
     * @return <code>true</code> if and only if the string is a non-empty string
     *         containing digits only.
     */
    public static boolean isNumeric(String string) {
        if (string == null || string.length() < 1) {
            return false;
        }
        char[] charArray = string.toCharArray();
        for (int i = charArray.length-1; i >= 0; i--) {
            if (!Character.isDigit(charArray[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether the specified string only contains alphabetic
     * characters.
     * @param string the string to inspect.
     * @return <code>true</code> if and only if the string is a non-empty string
     *         containing alphabetic characters only.
     */
    public static boolean isAlphabetic(String string) {
        if (string == null || string.length() < 1) {
            return false;
        }
        char[] charArray = string.toCharArray();
        for (int i = charArray.length-1; i >= 0; i--) {
            if (!Character.isLetter(charArray[i])) {
                return false;
            }
        }
        return true;
    }


    /**
     * @return a String which is <code>s</code> with all the whitespace removed
     * @since Kevin Flattery Tue May 21 2002
     */
    public static String stripWhitespace(String s) {
        final StringTokenizer sT = new StringTokenizer(s, " ");
        final StringBuffer sB = new StringBuffer();
        while (sT.hasMoreTokens()) {
            sB.append(sT.nextToken().trim());
        }
        return sB.toString();
    }

    /**
     * @param aString the string to do the substring on.
     * @param aFromIndex from position
     * @param aToIndex to position
     * @param aTrimmed indicates whether the trailing blanks shoul be trimmed
     * @return a Substring
     */
    public static String grabSubstring(String aString, int aFromIndex,
                                       int aToIndex, boolean aTrimmed) {
        String subString = null;
        if ((aFromIndex < aToIndex) && (aString != null) &&
            aString.length() >= aToIndex) {
            subString = aString.substring(aFromIndex, aToIndex);
            if (aTrimmed)
                subString = subString.trim();
        }
        return subString;
    }

    /**
     * Checks if the string object is NULL or has EMPTY_STRING
     * @param aString
     * @return boolean true if the string passed in is null or EMPTY_STRING
     * @since Nov 2003, Senthil Kumar
     */
    public static boolean isNullOrEmpty(String aString) {
        return (aString == null || EMPTY_STRING.equals(aString.trim()));
    }

    public static boolean hasValue(String aString) {
        return !isNullOrEmpty(aString);
    }

    /**
     * Checks if the string object is NULL, blank, or EMPTY_STRING.
     * A String is considered blank if its trim() method reduces its length to 0.
     *
     * @param aString
     * @return boolean true if the string passed in is null, blank, or EMPTY_STRING
     */
    public static boolean isBlank(String aString) {
        return (aString == null || aString.trim().length() == 0);
    }

    /**
     * Returns the upshifted string. Null or empty string is returned as such.
     *
     * @param aString
     * @return string that is converted to uppercase
     * @since Apr 24, 2003. Senthil Kumar
     */
    public static String toUpperCase(String aString) {
        return (StringUtil.isNullOrEmpty(aString)) ?
                aString : aString.toUpperCase();
    }


    /**
     * Replace all occurences of the given pattern in the given string to
     * be encoded with the given replacement.
     * @param aWord the aWord to perform the replacement
     * @param aFind the sequence to locate
     * @param aReplace the string to replace it with
     */
    public static String replaceAll(String aWord, String aFind,
                                    String aReplace ) {
        return replaceAll(aWord, aFind, aReplace, 0, -1);
    }

    /**
     * Replace all occurences of the given pattern in the given string to
     * be encoded with the given replacement, beginning at the given
     * staring position.
     * @param aWord the aWord to perform the replacement
     * @param aFind the sequence to locate
     * @param aReplace the string to replace it with
     * @param aStartPos the position to begin at
     */
    public static String replaceAll(String aWord, String aFind,
                                    String aReplace, int aStartPos ) {
        return replaceAll(aWord, aFind, aReplace, aStartPos, -1);
    }

    /**
     * Replace all occurences of the given pattern in the given string to
     * be encoded with the given replacement, beginning at the given starting
     * position up to the given end position.
     * @param aWord the word to perform the replacement
     * @param aFind the sequence to locate
     * @param aReplace the string to replace it with
     * @param aStartPos the position to begin at
     * @param aEndPos the position to stop at.  An -1 indicates to replace all
     * occurences.
     */
    public static String replaceAll(String aWord, String aFind,
                                    String aReplace, int aStartPos, int aEndPos ) {

        StringBuffer word = new StringBuffer(aWord);

        int pos = word.toString().indexOf(aFind, aStartPos);

        if (-1 == aEndPos) {
            aEndPos = word.length() - 1;
        }

        int offset = aReplace.length() - aFind.length();

        while(-1 != pos) {

            if(-1 != aEndPos && pos > aEndPos) {
                break;
            }

            word.delete(pos, pos + aFind.length() );
            word.insert(pos, aReplace);

            pos = word.toString().indexOf(aFind, pos+offset+1);
            aEndPos += offset;
        }
        return word.toString();
    }

    /**
     * Replace the first occurences of the given pattern in the given string to
     * be encoded with the given replacement.
     * @param aWord the aWord to perform the replacement
     * @param aFind the sequence to locate
     * @param aReplace the string to replace it with
     */
    public static String replaceFirst(String aWord, String aFind,
                                      String aReplace ) {

        String word = aWord;

        int pos = aWord.indexOf(aFind, 0);

        if (pos != -1) {
            word =  replaceAll(aWord, aFind, aReplace, 0, pos);
        }

        return word;
    }

    /**
     * Replace the last occurences of the given pattern in the given string to
     * be encoded with the given replacement.
     * @param aWord the aWord to perform the replacement
     * @param aFind the sequence to locate
     * @param aReplace the string to replace it with
     */
    public static String replaceLast(String aWord, String aFind,
                                     String aReplace ) {

        String word = aWord;

        int pos = aWord.lastIndexOf(aFind);

        if (pos != -1) {
            word =  replaceAll(aWord, aFind, aReplace, pos, -1);
        }

        return word;
    }

    /**
     * Replace the start of the given pattern in the given string with the given replacement.
     * @param aWord the aWord to perform the replacement
     * @param aFind the sequence to locate
     * @param aReplace the string to replace it with
     */
    public static String replaceStart(String aWord,
                                      String aFind,
                                      String aReplace) {
        String word = aWord;
        if (aWord.startsWith(aFind)) {
            word = replaceFirst(aWord, aFind, aReplace);
        }
        return word;
    }

    public static String replaceEnd(String aWord,
                                    String aFind,
                                    String aReplace ) {
        String word = aWord;
        if (aWord.endsWith(aFind)) {
            int index =  aWord.lastIndexOf(aFind);
            word = aWord.substring(0, index);
            word += aReplace;
        }
        return word;
    }

    /**
     * Finds the last occurences of the given pattern in the given string and
     * replaces everything from the last pattern to the end of the string with
     * the given replacement.
     * @param aWord the aWord to perform the replacement
     * @param aFind the sequence to locate
     * @param aReplace the string to replace it with
     */
    public static String replaceLastTillEnd(String aWord,
                                            String aFind,
                                            String aReplace) {
        String word = aWord;
        int pos = (aWord != null) ? aWord.lastIndexOf(aFind) : -2;
        if (pos >= 0) {
            word = aWord.substring(0, pos);
            word += aReplace;
        }
        return word;
    }

    /**
     * Strips the 'strip' string, if found, at the end of 'aWord'
     * @param aWord whose end to be stripped
     * @param strip the string to stripped
     * @return stripped string if found, otherwise the original word
     */
    public static String stripEnd(String aWord,
                                  String strip ) {
        String word = aWord;
        if (aWord.endsWith(strip)) {
            int index =  aWord.lastIndexOf(strip);
            word = aWord.substring(0, index);
        }
        return word;
    }

    /**
     * @param aValue the String to pad
     * @param aLength the number of spaces to pad
     * @return a left padded string
     */
    public static String leftPad(String aValue, int aLength) {
        return pad(aValue, aLength, SPACE_CHAR, true);
    }

    /**
     * @param aValue the String to pad
     * @param aLength the number of characters to pad
     * @param aPadValue the value to pad with
     * @return a left padded string
     */
    public static String leftPad(String aValue, int aLength, char aPadValue) {
        return pad(aValue, aLength, aPadValue, true);
    }

    /**
     * @param aValue the String to pad
     * @param aLength the number of spaces to pad
     * @return a right padded string
     */
    public static String rightPad(String aValue, int aLength) {
        return pad(aValue, aLength, SPACE_CHAR, false);
    }

    /**
     * @param aValue the String to pad
     * @param aLength the number of characters to pad
     * @param aPadValue the value to pad with
     * @return a right padded string
     */
    public static String rightPad(String aValue, int aLength, char aPadValue) {
        return pad(aValue, aLength, aPadValue, false);
    }

    /**
     * @param aValue the String to pad
     * @param aLength the number of characters to pad
     * @param aPadValue the value to pad with
     * @param aLeftPad indicates whether to pad left or right
     * @return a padded string (left or right as specified by parameter)
     */
    private static String pad(String aValue, int aLength, char aPadValue,
                              boolean aLeftPad) {
        String value = aValue != null ? aValue : SPACE_STRING;
        StringBuffer sb = new StringBuffer(value);
        if (aLeftPad) {
            while (sb.length() < aLength) {
                sb.insert(0, aPadValue);
            }
        } else {
            while (sb.length() < aLength) {
                sb.append(aPadValue);
            }
        }
        sb.setLength(aLength);
        return sb.toString();
    }

    /**
     * @param aString the String to perform the numeric check on
     * @return true if the string is not null and contains only numbers,
     * false otherwise
     */
    public static boolean isNumber(String aString) {
        boolean checkPassVal = false;

        if (aString != null) {
            checkPassVal = true;
            for (int i=0; i<aString.length(); i++) {
                char c = aString.charAt(i);
                if (!Character.isDigit(c)) {
                    checkPassVal = false;
                    break;
                }
            }
        }

        return checkPassVal;

    }

    /**
     * @param aString the String to perform the double check on
     * @return true if the string is not null and contains a double,
     * false otherwise
     */
    public static boolean isDouble(String aString) {
        boolean checkPassVal = false;

        try {
            Double.parseDouble(aString);
            checkPassVal = true;
        } catch (Exception ex) {
            //ignore
        }

        return checkPassVal;

    }


    public static String capatalise(String aString) {
        String capatalised = aString;

        if (!isBlank(aString)) {
            String head = aString.substring(0,1).toUpperCase();
            String tail = "";
            if (aString.length() > 1) {
                tail = aString.substring(1).toLowerCase();
            }
            capatalised = head + tail;
        }

        return capatalised;
    }

    /**
     * @param aString the string to put quotes around
     * @return a string enclosed by quotes.  Double quotes in the string will
     * be replaced with single quotes.
     * For null strings a "" would be returned.
     */
    public static String addQuotes(String aString) {
        String modifiedString = QUOTE_DOUBLE;

        if (!isBlank(aString)) {
            // To ensure that there are no double quotes in the string,
            // we replace them with single quotes
            modifiedString += StringUtil.replaceAll(aString, QUOTE_DOUBLE, QUOTE_SINGLE);
        }

        return modifiedString += QUOTE_DOUBLE;
    }

    /**
     * @param aDate the date to put quotes around
     * @return a date formatted as a string enclosed by quotes.
     * For null strings a "" would be returned.
     */
    public static String addQuotes(Date aDate) {
        return addQuotes(DateUtil.format(aDate));
    }

    /**
     * @param aDataList the Collection containing Data
     * @return a StringReader created by iterating through the Collection
     * and using the toString method on the Data.  An end-of-line character
     * is added after each iteration.
     */
    public static Reader convertToReader(Collection aDataList) {

        String contents = "";

        if (aDataList != null) {
            for (Object dataLine : aDataList) {
                String stringLine = dataLine.toString();
                if (stringLine == null) {
                    stringLine = "";
                }
                contents += stringLine + EOL;
            }
        }

        return new StringReader(contents);
    }


    /**
     * @param aString the String to analyse
     * @return the numbers in the String
     */
    public static String getNumbers(String aString) {
        String numberString = "";
        if (aString != null) {
            for (int i=0; i<aString.length(); i++) {
                if (Character.isDigit(aString.charAt(i))) {
                    numberString += aString.charAt(i);
                }
            }
        }
        return numberString;
    }


    public static int toInt(String string, int dflt) {
        try {
            return Integer.parseInt(string);
        } catch (Exception ignored) {
        }
        return dflt;
    }

    /**
     * Returns default string (EMPTY_STRING, ie "") when the param is null,
     * just returns the param otherwise.
     *
     * @param str
     * @return
     */
    public static String getDefaultWhenNull(String str) {
        return (str == null) ? EMPTY_STRING : str;
    }

    /**
     * @param string the string to convert to long
     * @param dflt the default value
     * @return the parsed long value using the string parameter.  The default will be returned
     * if it cannot be parsed.
     */
    public static long toLong(String string, long dflt) {
        try {
            return Long.parseLong(string);
        } catch (Exception ignored) {
        }
        return dflt;
    }

    /**
     * @param aString1 the string to search
     * @param aString2 the value to search for
     * @return true if string1 contains the value in string2, false otherwise.  Will ignore the case.
     */
    public static boolean containsIgnoreCase(String aString1, String aString2) {
        boolean contains = false;
        if (aString1 != null && aString2 != null) {
            contains = aString1.toLowerCase().contains(aString2.toLowerCase());
        }
        return contains;
    }

    /**
     * @param aString the String to trim
     * @param aRequiredSize the max length of the string
     * @return the String trimmed to the specified size.  It will only be trimmed if
     * the string is longer than the specified size
     */
    public static String trimToSize(String aString, int aRequiredSize) {
        String retString = aString;
        if (aString.length() > aRequiredSize) {
            retString = aString.substring(0, aRequiredSize);
        }
        return retString;
    }

    /**
     * Tries to convert the string to long quietly. A null is returned if an exception occurs.
     *
     * @param string the number
     * @return Long could be null
     */
    public static Long parseLongQuiet(String string) {
        Long val = null;
        if (!isBlank(string)) {
            try {
                val = Long.valueOf(string);
            } catch (Exception ignored) {
            }
        }
        return val;
    }

    /**
     * Tries to convert the string to Integer quietly. A null is returned if an exception occurs.
     *
     * @param string the number
     * @return Integer could be null
     */
    public static Integer parseIntegerQuiet(String string) {
        Integer val = null;
        if (!isBlank(string)) {
            try {
                val = Integer.valueOf(string);
            } catch (Exception ignored) {
            }
        }
        return val;
    }

    /**
     * Comparator that sort Strings and ignoring the case
     */
    public final static Comparator<String> DEFAULT_IGNORE_CASE_COMPARATOR = new Comparator<String>() {
         public int compare(String string1, String string2) {
             if (string1 != null && string2 != null) {
                 return (string1.compareToIgnoreCase(string2));
             }
             return 0;
         }
     };
    
    /**
     * Modifies the text so that there is a maximum of 1 space between each word, and no spaces at the start and end.
     * @param originalText the String to be modified
     * @return the String modified to remove any excess space characters
     */
    public static String removeExcessSpaces(String originalText) {
        String modifiedText = "";
        if (originalText != null) {
            //Remove any multiple spaces between words
            modifiedText = originalText.replaceAll("\\b\\s{2,}\\b", " ");
            //Remove any opening or closing spaces
            modifiedText = modifiedText.trim();
        }
        return modifiedText;
    }

    public static boolean isChanged(Object old, Object neu) {
        return (old == null && neu != null) ||
            (old != null && !old.equals(neu));
    }

    /**
     * Removes all whitespace from the String.
     * @param inString the input String
     * @return a String with all the whitespace removed
     */
    public static String removeAllWhiteSpace(String inString) {
        if (inString == null) {
            return null;
        } else {
            return inString.replaceAll(SINGLE_SPACE_REGEXP, EMPTY_STRING);
        }
    }

    /**
     * A simple utility method for word wrapping long Strings to the required (approximate) length. The wrapping
     * will occur at the first space character after the specified length.
     * @param aString  the String to word wrap
     * @param desiredLength the point after which wrapping should occur
     * @return the word wrapped String
     */
    public static String wordWrapString(String aString, int desiredLength) {
        if (StringUtil.isNullOrEmpty(aString)) {
            return aString;
        }
        //If string is small enough not to require wrapping there is no need to do anything
        if (aString.length() <= desiredLength) {
            return aString;
        }
        //Otherwise find the first space that occurs after the wrap point and replace it with a newline
        int indexOfSpace = aString.indexOf(SPACE_CHAR, desiredLength);
        StringBuffer sb = new StringBuffer();
        if (indexOfSpace >= 0) {
            //Add the text up to the wrap point to the buffer
            sb.append(aString.substring(0, indexOfSpace));
            sb.append(EOL);
            //Find the first space in the remainder - this is where the wrapping will occur
            String remainder = aString.substring(indexOfSpace + 1);
            sb.append(StringUtil.wordWrapString(remainder, desiredLength));
        } else {
            sb.append(aString);
        }
        return sb.toString();
    }

    /**
     * Turns a list of Strings into a single String with an sequence number preceding each element String and a line
     * break between each element String.
     * @param stringList a List of String objects
     * @return a String made up of all the element Strings in the original list, each preceded by a sequence number
     * representing its position in the List, and with a line break between each element String
     */
    public static String sequenceStringList(List<String> stringList) {
        if (stringList.isEmpty()) {
            return EMPTY_STRING;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= stringList.size(); i++) {
            sb.append(i);
            sb.append(PERIOD_CHAR);
            sb.append(SPACE_CHAR);
            sb.append(stringList.get(i - 1));
            if (stringList.size() > i) {
                sb.append(EOL);
            }
        }
        return sb.toString();
    }

    /**
     * Surrounds the input String with double quotes, unless the input String is null in which case null is returned.
     * @param aString the String to be surrounded with double quotes
     * @return the String surrounded by double quotes
     */
    public static String surroundWithDoubleQuotes(String aString) {
        if (aString == null) {
            return null;
        }
        return QUOTE_DOUBLE + aString + QUOTE_DOUBLE;
    }
    
	/**
	 * To java identifier.
	 * 
	 * @param s the s
	 * 
	 * @return the string
	 */
	public static String toJavaIdentifier(String s) {
		if(StringUtil.isNullOrEmpty(s)) {
			return "";
		}
		StringBuilder res = new StringBuilder();
		int idx = 0;
		char c = s.charAt(idx);
		if (Character.isJavaIdentifierStart(c)) {
			res.append(c);
			idx++;
		} else if (Character.isJavaIdentifierPart(c)) {
			res.append("");
		}
		while (idx < s.length()) {
			c = s.charAt(idx++);
			res.append(Character.isJavaIdentifierPart(c) ? c : "");
		}
		return res.toString();
	}

    /**
     * Checks if two strings are equal.  A blank String is considered equal to a null string in this case
     * @param s1 String 1
     * @param s2 String 2
     * @return a boolean indicating if the two Strings are equal
     */
    public static boolean isEqualIgnoreNull(String s1, String s2) {
        return (isBlank(s1) && isBlank(s2)) || (s1 != null && s1.equals(s2));
    }

    /**
     * Removes leading and trailing spaces from a String. Safe to call on a null String.
     * @param aString - the String from which leading and trailing spaces are to be removed
     * @return a String with no leading or trailing spaces, or null if the input String was null
     */
    public static String trim(String aString) {
        if (aString == null) {
            return aString;
        } else {
            return aString.trim();
        }
    }


    /**
     * Removes leading and trailing spaces from a String, and forces the String to uppercase. Safe to call on a null
     * String.
     * @param aString - the String to be trimmed and uppercased
     * @return an uppercase String with no leading or trailing spaces, or null if the input String was null
     */
    public static String trimToUpperCase(String aString) {
        return trim(toUpperCase(aString));
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation consists of a list of the array's elements.
     * Adjacent elements are separated by the characters <tt>", "</tt> (a comma
     * followed by a space).  Elements are converted to strings as by
     * <tt>String.valueOf(long)</tt>.  Returns <tt>""</tt> if <tt>a</tt>
     * is <tt>null</tt>. Different to Arrays.toString because we don't
     * want the result enclosed in "[]"s
     *
     * @param ids the array whose string representation to return
     * @return a string representation of <tt>a</tt>
     */
    public static String idsArrayToSqlString(long[] ids) {
        if (ids == null)
            return EMPTY_STRING;
        int iMax = ids.length - 1;
        if (iMax == -1) {
            return EMPTY_STRING;
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(ids[i]);
            if (i == iMax) {
                return b.toString();
            }
            b.append(", ");
        }
    }

    /**
     * Method used to convert a string into Initial Caps format.
     * e.g. 'the cat shat on the mat' becomes 'The Cat Shat On The Mat'
     * @param aString String containing the text to convert
     * @return String converted into initial capital format, if string is null returns an empty string.
     */
    public static String initialCaps(String aString) {
        if (isNullOrEmpty(aString)) {
            return StringUtil.EMPTY_STRING;
        }
        
        StringBuilder convertedString = new StringBuilder();
        boolean spaceFound = false;

        for(int i = 0 ; i < aString.length() ; i++) {
            String currentChar = aString.substring(i, i + 1);
            String convertedLetter = currentChar;
            
            if (i == 0) {
                convertedLetter = currentChar.toUpperCase();
            }

            if (spaceFound && !isSpaceLikeCharacter(currentChar)){
                convertedLetter = currentChar.toUpperCase();
                spaceFound = false;
            }

            if (isSpaceLikeCharacter(currentChar)) {
                spaceFound = true;
            }
            convertedString.append(convertedLetter);
        }

        return convertedString.toString(); 

    }

    /**
     * Given a String containing 1 character will determine if it is space like. i.e. a space, slash, dash etc.
     * @param character  String containing one character. If string contains multiple characters will return false.
     * @return boolean if the one character matches on of the space like characters.
     */
    private static boolean isSpaceLikeCharacter(String character) {
        return (character.equals(SPACE_STRING)||
                character.equals(MINUS_SYMBOL) ||
                character.equals(FORWARD_SLASH)||
                character.equals(BACK_SLASH)||
                character.equals(UNDERSCORE)||
                character.equals(COMMA)||
                character.equals(SEMI_COLON));
    }

    /**
     * Creates a String containing all the array elements separated by the separator character
     * @param theArray an array of objects
     * @param theSeparator the character to use to separate each element in the output String
     * @return a String containing all the array elements separated by the separator character
     */
    public static String createConcatenatedStringFromArray(Object[] theArray, char theSeparator) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : theArray) {
            sb.append(String.valueOf(obj)).append(theSeparator);
        }
        //Remove the last separator if there is one
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    
    /**
     * Compares two Strings lexicographically. Null values are converted to empty Strings, and all Strings are trimmed
     * before the comparison is done.
     * @param theString the first String - may be null
     * @param theOtherString the second String - may be null
     * @return 0 if the two Strings are the same; a value less than 0 if the first String is lexicographically less than
     * the second; and a value greater than 0 if the first String is lexicographically greater than the second.
     */
    public static int compareStrings(String theString, String theOtherString) {
        String string = theString;
        if (StringUtil.isBlank(string)) {
            string = StringUtil.EMPTY_STRING;
        } else {
            string = string.trim();
        }
        String otherString = theOtherString;
        if (StringUtil.isBlank(otherString)) {
            otherString = StringUtil.EMPTY_STRING;
        } else {
            otherString = otherString.trim();
        }
        return string.compareTo(otherString);
    }

    /**
     * Creates a new String by concatenating all the elements passed in as parameters. Each element is separated by the
     * separator parameter
     * @param separator the separator
     * @param elements the elements to be concatenated
     * @return a String made up of the concatenated elements separated by the separator
     */
    public static String createSeparatedConcatenation(String separator, String... elements) {
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            if (!StringUtil.isBlank(element)) {
                if (sb.length() > 0) {
                    sb.append(separator);
                }
                sb.append(element.trim());
            }
        }
        return sb.toString();
    }


    /**
     * Removes all non-numeric characters from a String
     * @param theString from which the non-numeric characters are to be removed
     * @return a String consisting of all the digits in the input String
     */
    public static String removeNonNumericCharacters(String theString) {
        if (theString == null) {
            return theString;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : theString.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Removes all numeric characters from a String
     * @param theString from which the numeric characters are to be removed
     * @return a String consisting of all the non-numeric characters in the input String
     */
    public static String removeNumericCharacters(String theString) {
        if (theString == null) {
            return theString;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : theString.toCharArray()) {
            if (!Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Formats the Double value to a Money pattern removing the space between the "$" and Money
     * @param anAmount the amount
     * @return the formatted String that represent money
     */
    public static String getStringMoneyValue(Double anAmount) {
        return getStringMoneyValue(anAmount, false);
    }

    /**
     * Formats the double to a Money pattern
     * @param anAmount the amount
     * @param aSpaceAfterDollar boolean indicating to add a space after the dollar sign
     * @return the formatted String that represent money
     */
    public static String getStringMoneyValue(Double anAmount, boolean aSpaceAfterDollar) {
        String value = null;
        if (anAmount != null) {
            DecimalFormat f = new DecimalFormat("#,##0.00");
            value = DOLLAR_STRING + (aSpaceAfterDollar ? SPACE_STRING : EMPTY_STRING) + f.format(anAmount);
        }
        return value;
    }

    /**
     * Remove leading zeroes from a String
     * @param str the string
     * @return the String with zeroes removed
     */
    public static String removeLeadingZeros(String str) {
        int valueLength = str.length();
        for (int i = 0; i < valueLength; i++) {
            if (StringUtil.startsWith(str, String.valueOf(ZERO_CHAR))) {
                str = str.substring(1, str.length());
            } else {
                break;
            }
        }
        return str;
    }

}
