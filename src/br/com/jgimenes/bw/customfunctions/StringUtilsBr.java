package br.com.jgimenes.bw.customfunctions;

import com.tibco.xml.cxf.common.annotations.XPathFunction;
import com.tibco.xml.cxf.common.annotations.XPathFunctionExample;
import com.tibco.xml.cxf.common.annotations.XPathFunctionGroup;
import com.tibco.xml.cxf.common.annotations.XPathFunctionParameter;

/**
 *
 * TIBCO BusinessWorks 6.X - Custom String Functions for use in Brazil.
 *
 * @author jgimenes
 * @version 1.0
 * 
 */

@XPathFunctionGroup(category = "Custom String Functions - Brasil", prefix = "br", namespace = "http://tibco.bw.StringToolsBr", helpText = "Brazil - Custom-built functions for manipulating strings.")
public class StringUtilsBr {

	/**
	 * 
	 * Returns the ZIP code in a standardized 99999-999 format.
	 * 
	 * @param zipCode
	 * @return standardized ZIP code
	 * 
	 */

	@XPathFunction(helpText = "Returns the ZIP code in a standardized 99999-999 format", parameters = {
			@XPathFunctionParameter(name = "zipCode", optional = false, optionalValue = "") }, displayName = "zip-code-format", returnType = "string", examples = {
					@XPathFunctionExample(example = "format-zip-code(\"99999999\")", returns = "99999-999") })

	public String zipCodeFormat(String zipCode) {
		zipCode = textNormalizer.normalizeText(zipCode).trim();
		try {
			if (zipCode.length() == 8) {
				zipCode = textFormatter.textFormat(zipCode, "#####-###");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return zipCode;
	}

	/**
	 * 
	 * Returns the CNPJ number in a standardized 99.999.999/9999-99 format.
	 * 
	 * @param numberCNPJ
	 * @return standardized CNPJ
	 * 
	 */

	@XPathFunction(helpText = "Returns the CNPJ number in a standardized 99.999.999/9999-99 format", parameters = {
			@XPathFunctionParameter(name = "CNPJ", optional = false, optionalValue = "") }, displayName = "cnpj-formart", returnType = "string", examples = {
					@XPathFunctionExample(example = "format-cnpj(\"78408074000159\")", returns = "78.408.074/0001-59") })

	public String formatCNPJ(String cnpjNumber) {
		cnpjNumber = textNormalizer.normalizeText(cnpjNumber).trim();
		try {
			if (cnpjNumber.length() == 14) {
				cnpjNumber = textFormatter.textFormat(cnpjNumber, "##.###.###/####-##");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cnpjNumber;
	}

	/**
	 *
	 * Validates a Brazilian CNPJ number.
	 * 
	 * @param CNPJ
	 * @return boolean
	 * 
	 */

	@XPathFunction(helpText = "Validates a Brazilian CNPJ number.", parameters = {
			@XPathFunctionParameter(name = "CNPJ", optional = false, optionalValue = "") }, displayName = "cnpj-validate", returnType = "boolean", examples = {
					@XPathFunctionExample(example = "cnpj-validade(\"78408074000159\")", returns = "true") })

	public Boolean validadeCNPJ(String cnpjNumber) {
		cnpjNumber = textNormalizer.normalizeText(cnpjNumber);
		boolean isValidCNPJ = false;
		try {

			if (cnpjNumber.length() == 14) {

				Integer dig1 = calculateDV(cnpjNumber.substring(0, 12), weightCNPJ);
				Integer dig2 = calculateDV(cnpjNumber.substring(0, 12) + dig1, weightCNPJ);
				if (cnpjNumber.equals(cnpjNumber.substring(0, 12) + dig1.toString() + dig2.toString())) {
					isValidCNPJ = true;
				} else {
					isValidCNPJ = false;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return isValidCNPJ;

	}

	/**
	 * 
	 * Returns the CPF number in a standardized 999.999.999-99 format.
	 * 
	 * @param numeroCPF
	 * @return standardized CPF
	 * 
	 */

	@XPathFunction(helpText = "Returns the CPF number in a standardized 999.999.999-99 format", parameters = {
			@XPathFunctionParameter(name = "CPF", optional = false, optionalValue = "") }, displayName = "cpf-formart", returnType = "string", examples = {
					@XPathFunctionExample(example = "cpf-format(\"88107069005\")", returns = "881.070.690-05") })

	public String formatCPF(String cpfNumber) {
		cpfNumber = textNormalizer.normalizeText(cpfNumber).trim();
		try {
			if (cpfNumber.length() == 11) {
				cpfNumber = textFormatter.textFormat(cpfNumber, "###.###.###-##");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cpfNumber;
	}

	/**
	 *
	 * Validates a Brazilian CPF number.
	 * 
	 * @param CPF
	 * @return boolean
	 * 
	 */

	@XPathFunction(helpText = "Validates a Brazilian CPF number.", parameters = {
			@XPathFunctionParameter(name = "CPF", optional = false, optionalValue = "") }, displayName = "cpf-validate", returnType = "boolean", examples = {
					@XPathFunctionExample(example = "cpf-validade(\"44715595087\")", returns = "true") })

	public Boolean validateCPF(String cpfNumber) {
		cpfNumber = textNormalizer.normalizeText(cpfNumber);
		boolean isValidaCpf = false;
		try {

			if (cpfNumber.length() < 11) {
				return false;
			} else {
				Integer dig1 = calculateDV(cpfNumber.substring(0, 9), weightCPF);
				Integer dig2 = calculateDV(cpfNumber.substring(0, 9) + dig1, weightCPF);
				if (cpfNumber.equals(cpfNumber.substring(0, 9) + dig1.toString() + dig2.toString())) {
					isValidaCpf = true;
				} else {
					isValidaCpf = false;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return isValidaCpf;

	}

	/*
	 * 
	 * Specification of weights for CPF/CNPJ check digit calculation.
	 * 
	 */

	private static final int[] weightCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] weightCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	/**
	 * 
	 * Calculates the check digit for a Brazilian CPF or CNPJ number.
	 * 
	 * @param str
	 * @param peso
	 * @return value
	 * 
	 */
	private static int calculateDV(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

}
