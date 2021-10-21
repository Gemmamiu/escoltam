package com.escoltam.springboot.projecte.escoltam.auth;
/**
 * Classe que emmagatzema les claus
 * @author Gemma Rica
 *
 */
public class JwtConfig {
	
	/**
	 * Clau que sempre es guarda al servidor
	 */
	public static final String SECRET_KEY = "clau.secreta.12345";
	
	/**
	 * Clau RSA privada
	 */
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEogIBAAKCAQEA0pqDLzG01d4KQCOxa3nKEGuwho/JPwHydUE8dliCQiJFc6qs\r\n"
			+ "umf8N9Ui2iznWwhkGYTAICRnD89Bmnxj/8z8Xjas/M3ar5ZsoyAJWVomuqYYsRaB\r\n"
			+ "rm8NGQ/XMYJ5e2ydGXCvZVP217hwMFP3ecv1Q1naco0MbUdb2Nm9+OBe+q78hdwk\r\n"
			+ "TVZC+yPXofc1uc+kewoyccLlhWpy8xOwiN1AMI5H4vGmWxTygB5+BNA5a0oyWNDC\r\n"
			+ "JRHZzuwOywWm45IYZT/FX5HHZ1lOZrzHreZZWJ8qsPBbxpDuNkdL8YPWMefSKN3f\r\n"
			+ "pIS1twY0s/iqg022goRC3FyAgsJ6NdV0ixDSMQIDAQABAoIBACd+dk9pYOIia4Wv\r\n"
			+ "q9vd0PjXWRlC6Zh5QwCeJTqESpkgWCnivdWPHotR2uFTPmeh4TOv41+js/gRA9p2\r\n"
			+ "rUIRLNp2ImaeK/51lRXaMiahc1XZRBQhhlwx0yD6CX7tWt68dZGJwjqcTlQR8Gf/\r\n"
			+ "tw8OIoZo2UBWFxh/I0g9PRTo7qbPxrxN4bu7MmtK2gm4N8pW5h3nkKcJ1+LOr68C\r\n"
			+ "0SToiHRyyBXuzTYDiIowyxKAKS9glMXb4REGIJVnYYcktqsXVHmHAfunB+iTSkDH\r\n"
			+ "W3tenKHWRe4cnyAobGipcwZ0dzHAPsmbiA99D2KnkkSeJU66Oz96QWtVftNquW7M\r\n"
			+ "u5Q9kOECgYEA8meZodsS/lYalKJvdXvez62boDTlAQX1LEYWmb0HAwcmmBnIX423\r\n"
			+ "fSXSZYtmrsnRCKDcMSXlnhwBGUBqDc3rqkdV2n3PINCw/lS87LzNSO8U8WrRJqWf\r\n"
			+ "oQTQl7S9r2Eji9aUaXOSedQqBf+BCvzm7K57bPTx7Lu5wn13q72n8TUCgYEA3mpR\r\n"
			+ "YaBcYsvWM10ifGh2DNF6xBeSIrllJLqvLoxP8NIEu7ov1cMPQFNP8ZQh2fX2463c\r\n"
			+ "LRPaVomiM5qO+p1LdDkWNlBt9yARh0SqfRvMHkaRhODrJggUvgb5OyJUor/H+KD5\r\n"
			+ "0J0Saze+NbMqzcp7vmtlLUX3F7yrjGdgRq2kGI0CgYADw+w1AWwoGzpKeMN2dbge\r\n"
			+ "TboPIQM1otwOFgCf3rnPKDtHPY9JPLBO91lvTl0H9gaTNbx13vrUG+dAdymukTZJ\r\n"
			+ "7NW+kRm4jsVRDgvpOX2O1nfi0B/zk7sJC0QaNyqDIOUmdOzVPoBV+B+2/CMLAqar\r\n"
			+ "ooI0TRG89aWLCdvkBQwoyQKBgElegxgUYUWJ/lAVUhH+F6sk0z2qlN91jwLtvmo5\r\n"
			+ "iQllDoCq66q1XOuYUA/eEMio1dfHe5E3MlhHsMUbID1V9BUT29rw70WNQ5r+sMry\r\n"
			+ "h4QZPVm7JHb4RXdmL4MtUQQbBalj2OTTW8cYrVtjjiQyvl1Tah3kLZ2b9G8tjtnh\r\n"
			+ "3/blAoGAP7Q6NI49ND+XqbtBn5cQBslew7S6L52AVCijEfGC9raZI6Q3zAIfdjST\r\n"
			+ "4nazDZYQIOsmn0Y8BSKpiYi94ZuquIMiukGIQDiYaPEujfxRX9cLre8tBbE/fKkp\r\n"
			+ "2ykfmlVcBKxyZPNmtXpeX+HgmEN/mEJLuI1PnLxwuz+3m4Be2i8=\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	/**
	 * Clau RSA publica
	 */
	public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0pqDLzG01d4KQCOxa3nK\r\n"
			+ "EGuwho/JPwHydUE8dliCQiJFc6qsumf8N9Ui2iznWwhkGYTAICRnD89Bmnxj/8z8\r\n"
			+ "Xjas/M3ar5ZsoyAJWVomuqYYsRaBrm8NGQ/XMYJ5e2ydGXCvZVP217hwMFP3ecv1\r\n"
			+ "Q1naco0MbUdb2Nm9+OBe+q78hdwkTVZC+yPXofc1uc+kewoyccLlhWpy8xOwiN1A\r\n"
			+ "MI5H4vGmWxTygB5+BNA5a0oyWNDCJRHZzuwOywWm45IYZT/FX5HHZ1lOZrzHreZZ\r\n"
			+ "WJ8qsPBbxpDuNkdL8YPWMefSKN3fpIS1twY0s/iqg022goRC3FyAgsJ6NdV0ixDS\r\n"
			+ "MQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}