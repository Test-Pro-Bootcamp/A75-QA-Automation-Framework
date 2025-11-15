import org.testng.annotations.DataProvider;

public class DataProvid {
        @DataProvider(name = "IncorrectLoginData")
        public static Object[][] getDataFromDataProviders() {

            return new Object[][]{
                    {"incorrect@testpro.io", "ACw0FWOe"},
                    {"felicia.clay@testpro.io", "incorrectPas"},
                    {"", "ACw0FWOe"},
                    {"incorrect@testpro.io", ""}
            };
        }
        @DataProvider(name = "incorrectURLs")
        public static Object[][] getDataFromDataProvidersurl() {

            return new Object[][]{
                    {"incorrect@testpro.io", "ACw0FWOe"},
                    {"felicia.clay@testpro.io", "incorrectPas"},
                    {"", "ACw0FWOe"},
                    {"incorrect@testpro.io", ""}
            };
        }
    }

