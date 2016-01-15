package one.equinox.pillow.segurata.test;


import one.equinox.pillow.segurata.annotations.*;
import one.equinox.symbols.Symbolize;

import java.util.Arrays;
import java.util.List;

import static one.equinox.pillow.segurata.test.symbols.SampleModelSymbols.*;


@Symbolize
public class SampleModel {
        @NotNull
        String notNull;
        @NotEmpty String notEmpty;
        @NotEmpty List<String> notEmptyList;
        @Max(10) int max10;
        @Min(10) int min10;
        //@GreaterThan(attribute= "max10") int greaterThanMax10;
        //@GreaterThan(attribute= "max10", acceptEqual= true) int greaterOrEqualThanMax10;
        @GreaterThan(attribute=MAX10) int greaterThanMax10;
        @GreaterThan(attribute=MAX10, acceptEqual=true) int greaterOrEqualThanMax10;
        @MatchesPattern(pattern = "A.*B") String matchesPattern;


        public SampleModel() {
                this.notNull = "aa";
                this.notEmpty = "aa";
                this.notEmptyList = Arrays.asList(new String[]{"a"});;
                this.max10 = 5;
                this.min10 = 15;
                this.greaterThanMax10 = 15;
                this.greaterOrEqualThanMax10 = 15;
                this.matchesPattern="AxxB";
        }

        public String getMatchesPattern() {
                return matchesPattern;
        }

        public void setMatchesPattern(String matchesPattern) {
                this.matchesPattern = matchesPattern;
        }

        public String getNotNull() {
                return notNull;
        }

        public void setNotNull(String notNull) {
                this.notNull = notNull;
        }

        public String getNotEmpty() {
                return notEmpty;
        }

        public void setNotEmpty(String notEmpty) {
                this.notEmpty = notEmpty;
        }

        public int getMax10() {
                return max10;
        }

        public void setMax10(int max10) {
                this.max10 = max10;
        }

        public int getMin10() {
                return min10;
        }

        public void setMin10(int min10) {
                this.min10 = min10;
        }

        public int getGreaterThanMax10() {
                return greaterThanMax10;
        }

        public void setGreaterThanMax10(int greaterThanMax10) {
                this.greaterThanMax10 = greaterThanMax10;
        }

        public int getGreaterOrEqualThanMax10() {
                return greaterOrEqualThanMax10;
        }

        public void setGreaterOrEqualThanMax10(int greaterOrEqualThanMax10) {
                this.greaterOrEqualThanMax10 = greaterOrEqualThanMax10;
        }

        public List<String> getNotEmptyList() {
                return notEmptyList;
        }

        public void setNotEmptyList(List<String> notEmptyList) {
                this.notEmptyList = notEmptyList;
        }
}
