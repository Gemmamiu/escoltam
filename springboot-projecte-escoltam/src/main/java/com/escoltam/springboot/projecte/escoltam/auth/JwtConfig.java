package com.escoltam.springboot.projecte.escoltam.auth;

public class JwtConfig {
	
	//Clau que sempre es guarda al servidor
	public static final String SECRET_KEY = "clau.secreta.12345";
	
	public static final String RSA_PRIVATE = "-----BEGIN PRIVATE KEY-----\r\n"
			+ "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCNxqjI4c/9e5ew\r\n"
			+ "meVvS24S43ywQN19R7IbvJmSUSMIRHSPpkmh7vNckr+OpoES7X5pVK463BNPpJBw\r\n"
			+ "y90maGahj3/SAwK3cSbsp/M/uLtCDnKxkIQ21Ik0iAK1tDXRhLw5XW3kP23rr3wd\r\n"
			+ "ssXJdZHBkou0JQ5uOfEV3Wf+e2nMGwyGO/AVRNuF1BKu2MYUH4t+OkQ+BVCZ3qwA\r\n"
			+ "Wp3azbiK817MN1ij3L/ItRipQqed6XUUZ/WXEvp+8ZVABDlfQ5dzFGwGLQvFeOeV\r\n"
			+ "SoocsD2+pZOh15RyfkiIphDd0FvFnpjzXGzljZa3bFyr0/v9A6wCf3Z3H6fM+AL1\r\n"
			+ "37MOhLv1AgMBAAECggEAERqm8TlA8PlQpxch9WfZu0CjodXpgrw8EhmSQ3MzcUNk\r\n"
			+ "9pGer4EW7hOsNYcD6mcpiYaUUHiNgd2+KUWHBCOzQgmAZ7NCSCRICGQItibQvJrm\r\n"
			+ "nmJrePvyI5rHDOnVVlYXqSoK4G8AkV8F78VKFFBxSbOm1BBmacjmu3cPHUYBUQTC\r\n"
			+ "Yr7rKoYMJcgcpgqjQHOzLN0eS8PB93JCK/IKxBMNf0raXKfourv14EOGWjsyL/ZA\r\n"
			+ "+Y9z8Qw1ar/6DVU20PWp8uRCJ9RH2+sRLRW1NuleDHwBoV5vpmI8/mUAjmNqB+dZ\r\n"
			+ "J82ZUHEtLUhKqkuXO9pJ7lJ59G5/7LT1bO7lRJQVjwKBgQC4Dfu7iarmPOHfBImz\r\n"
			+ "SPERGTFlxldPeYCZ25xVWLAGC34lXitdYOQwnmKqzuralxy3sVyfJOHTdT8IXLRs\r\n"
			+ "y4KUkBdJFvnk8BjNCw2FMOmqT9oma/jgBx3M5Kz4/mW3Whs7T00XueqG1nwWWJqw\r\n"
			+ "zrVglVEJ59/4U0LbEz9ORS306wKBgQDFMe5jSRKxFdg0RoaHNRfK+4Uh2cz/zvod\r\n"
			+ "Z5Tlkn06O7X+DCybQUPRvomU/XjUWuu6XZMd1RZHkDeRO5lbqwCW2rF3cHC6tysx\r\n"
			+ "u/WM4+vYQgeZIsO3fCsxKnT5hYCtq38v4p96Rll2RtnF/YrOL5FfoIU0mLBFFuR4\r\n"
			+ "+wNmgN1anwKBgAaLKLoAKP1KiNU++g5Pt5JeDO2LYatHrJTLxAEcyBVO70swz+Xf\r\n"
			+ "/fzkhKmB9cOTv8egHKTj0MuNzZHkid2cVqYlgU5t7LCBAMC5dd+YX5ZYhG79Q7nj\r\n"
			+ "RuHz91pa4Q7luzYemaUQTRBCK+M3fzhuAPDQHjN19PaFL0lOo9+KghnFAoGAT+z8\r\n"
			+ "BYwBonsLJa0MK9MuMJyfimff+jMnFzH7nM0yKp83FaBTmB3s4h+LXjMafV/YubHh\r\n"
			+ "xi6vGBRxIVF5yDjYRUygr5uIZXWGcWMQlKlw1zd0IvJ/R2hxjTz7KoOc80dWhs8g\r\n"
			+ "+ot3CUSQUfqA/y8yigLi2r2kfGxZ8Fs1Np+2mFsCgYEAtutR8e8UlzcmqrUkvAU3\r\n"
			+ "CoVXHJqVCsa41JDJllx+4d50sFEqkqCAC9uDkaREm3+3XEu3Uj8jcQU0rG/t8kt9\r\n"
			+ "l4RGSCX1cTfWz3nP0vHC4ViBmYJtMWMD3xng95R9/YY0WoFtR710JbWnFxO7xWpv\r\n"
			+ "OFBIPyv0yxjNu5qCQhkoGO8=\r\n"
			+ "-----END PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjcaoyOHP/XuXsJnlb0tu\r\n"
			+ "EuN8sEDdfUeyG7yZklEjCER0j6ZJoe7zXJK/jqaBEu1+aVSuOtwTT6SQcMvdJmhm\r\n"
			+ "oY9/0gMCt3Em7KfzP7i7Qg5ysZCENtSJNIgCtbQ10YS8OV1t5D9t6698HbLFyXWR\r\n"
			+ "wZKLtCUObjnxFd1n/ntpzBsMhjvwFUTbhdQSrtjGFB+LfjpEPgVQmd6sAFqd2s24\r\n"
			+ "ivNezDdYo9y/yLUYqUKnnel1FGf1lxL6fvGVQAQ5X0OXcxRsBi0LxXjnlUqKHLA9\r\n"
			+ "vqWTodeUcn5IiKYQ3dBbxZ6Y81xs5Y2Wt2xcq9P7/QOsAn92dx+nzPgC9d+zDoS7\r\n"
			+ "9QIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}