# Custom Functions TIBCO BusinessWorks 6/CE
<p>
<img src =https://img.shields.io/static/v1?label=licence&message=MIT&color=green />
<img src =https://img.shields.io/static/v1?label=status&message=Under%20Contruction&color=yellow />
</p>
  
Custom functions are user-defined functions that allow you to extend the functionality of TIBCO BusinessWorks. These functions can be created in Java and can be used in any BusinessWorks process to perform a specific task or to manipulate data.</p>

Here are some key characteristics of TIBCO BusinessWorks custom functions:

- Reusability: Custom functions can be reused across multiple projects, reducing the need to create the same functionality multiple times.
- Extensibility: Custom functions can be extended to meet specific business requirements by adding new functionality.
- Configurability: Custom functions can be configured to accept input parameters and to produce output parameters that can be used in other parts of the process.
- Scalability: Custom functions can be used in high-volume environments to handle large amounts of data.
- Maintenance: Custom functions can be maintained independently of the main BusinessWorks application, making it easier to fix bugs or add new features.

Overall, TIBCO BusinessWorks custom functions provide a flexible and powerful way to extend the capabilities of the platform and to create custom integration solutions that meet specific business needs.


### Topics

- [Functions](#functions)
  - [Custom Date Time Functions](#custom-date-time-functions)
  - [Custom String Functions](#custom-string-functions)
  - [Custom String Functions Brazil](#custom-string-functions-brazil)
- [Install](#install)
- [Uninstall](#uninstall)
- [MIT Licence](#mit-licence)

## Functions
This section provides an overview of the available custom functions and explains how to use them in your integration projects. 

We will present the purpose and functionality of each custom function, and provide examples of how they can be used in a BusinessWorks process.

By the end of this section, you should have a clear understanding of the available custom functions and how to use them effectively to meet your integration needs.

- ### Custom Date Time Functions
  Custom-built functions for manipulating dates and times.

  - #### epoch-to-human-readable() 
    **Description:** Convert Epoch time to a readable date format.<br />
    **Template:** epoch-to-human-readable(<< timestamp >>)<br />
    **Return Type:** string
    
      ##### Example:

        Input: dt:epoch-to-human-readable("1679332277")<br />
        Return: 2023-03-20T14:11:17.017-03:00
      
      ##### Example:  
      
        Input: dt:epoch-to-human-readable(xsd:string(tib:timestamp()))<br />
        Return: 2023-03-20T14:39:40.040-03:00
      
  - #### extract-day-of-year() 
    **Description:** Retrieves the day number within a year for a given date.<br />
    **Template:** extract-day-of-year(<< date >>)<br />
    **Return Type:** integer
    
      ##### Example:

        Input: dt:extract-day-of-year("2023-12-31")<br />
        Return: 365

  - #### extract-week-of-year() 
    **Description:** Retrieves the week number within a year for a given date.<br />
    **Template:** extract-week-of-year(<< date >>)<br />
    **Return Type:** integer
    
      ##### Example:

        Input: dt:extract-week-of-year("2023-12-31")<br />
        Return: 53

  - #### epoch-to-human-readable() 
    **Description:** Convert a readable date format to an Epoch timestamp.<br />
    **Template:** human-readable-to-epoch(<< datetime >>)<br />
    **Return Type:** string
    
      ##### Examples:

        Input: dt:human-readable-to-epoch("2023-03-20T14:11:17.017-03:00")<br />
        Return: 1679332277

      ##### Examples:

        Input: dt:human-readable-to-epoch(xsd:string(current-dateTime()))<br />
        Return: 1679336875

- ### Custom String Functions
  Custom-built functions for manipulating strings.
  
    - #### count-lines() 
      **Description:** Obtain the line count for a given string.<br />
      **Template:** count-lines(<< string-text >>)<br />
      **Return Type:** integer
    
      ##### Example:

          Input: su:count-lines("first line. 
                                second line.")
          Return: 2

    - #### count-words() 
      **Description:** Obtain the words count for a given string.<br />
      **Template:** count-words(<< string-text >>)<br />
      **Return Type:** integer
    
      ##### Example:

          Input: su:count-words("word1 word2 word3 word4")
          Return: 4

    - #### mask-credit-card() 
      **Description:** Mask credit card number.<br />
      **Template:** mask-credit-card(<< credit-card-number >>)<br />
      **Return Type:** string
    
      ##### Example:

          Input: su:mask-credit-card("5348 0866 2159 5908")
          Return: 5***********5908

    - #### mask-formatter() 
      **Description:** Takes a string and formats it based on a given mask.<br />
      **Template:** mask-formatter(<< string-text >>, << mask >>)<br />
      **Return Type:** string
    
      ##### Example:

          Input: su:mask-formatter("999999999", "+55 11 #####-####")
          Return: +55 11 99999-9999

    - #### normalize-string() 
      **Description:** Cleans a string by removing all non-alphanumeric characters and keeping only letters and numbers.<br />
      **Template:** normalize-string(<< string-text >>)<br />
      **Return Type:** string
    
      ##### Example:

          Input: su:normalize-string("a|b-c*d%e$f&g")
          Return: abcdefg

    - #### remove-accents() 
      **Description:** Convert accented characters to non-accented characters in a string.<br />
      **Template:** remove-accents(<< string-text >>)<br />
      **Return Type:** string
    
      ##### Example:

          Input: su:remove-accents("áàâãç")
          Return: aaac

    - #### string-reverse() 
      **Description:** Takes a string as an input and returns a new string with the characters in the original string reversed.<br />
      **Template:** string-reverse(<< string-text >>)<br />
      **Return Type:** string
    
      ##### Example:

          Input: su:string-reverse("all you need is love")
          Return: evol si deen uoy lla

    - #### validade-email() 
      **Description:** Check the validity of an email address using regular expressions.<br />
      **Template:** validade-email(<< email >>)<br />
      **Return Type:** boolean
    
      ##### Example:

          Input: su:validade-email("user@email.com")
          Return: true

      ##### Example:

          Input: su:validade-email("user")
          Return: false

- ### Custom String Functions Brazil
  Custom-built functions for manipulating strings - Brazil.
  
    - #### cnpj-formart() 
      **Description:** Returns the CNPJ number in a standardized 99.999.999/9999-99 format.<br />
      **Template:** cnpj-formart(<< CNPJ >>)<br />
      **Return Type:** string
    
      ##### Example:

          Input: br:cnpj-format("78408074000159")
          Return: 78.408.074/0001-59

    - #### cpf-formart() 
      **Description:** Returns the CPF number in a standardized 999.999.999-99 format.<br />
      **Template:** cpf-formart(<< CPF >>)<br />
      **Return Type:** string
    
      ##### Example:

          Input: br:cpf-format("88107069005")
          Return: 881.070.690-05

    - #### cnpj-validate()
      **Description:** Validates a Brazilian CNPJ number.<br />
      **Template:** cnpj-validate(<< CNPJ >>)<br />
      **Return Type:** boolean
    
      ##### Example:

          Input: br:cnpj-validade("78408074000159")
          Return: true

      ##### Example:

          Input: br:cnpj-validade("78408074000150")
          Return: false

   - #### cpf-validate()
      **Description:** Validates a Brazilian CPF number.<br />
      **Template:** cpf-validate(<< CPF >>)<br />
      **Return Type:** boolean
    
      ##### Example:

          Input: br:cpf-validade("44715595087")
          Return: true

      ##### Example:

          Input: br:cpf-validade("44715595080")
          Return: false

    - #### zip-code-format() 
      **Description:** Returns the ZIP code in a standardized 99999-999 format.<br />
      **Template:** zip-code-format(<< zipCode >>)<br />
      **Return Type:** string
    
      ##### Example:

          Input: br:zip-code-format("11750000")
          Return: 11750-000


## Install

1- Open a terminal and run the following command: `gh repo clone jgimenes/bw6-custom-functions`. This will clone the repository to your local machine.<br >
2- To import the project, open your **TIBCO BusinessStudio** Integrated Development Environment (IDE) and follow the steps below.<br/>
3- In the IDE, select **"File"** from the menu bar and then choose **"Import"**.<br />
4- In the **"Select an import wizard" type **"Projects from Folder or Archive"** and click **"Next"**. <br />
5- In the **"Import Source"** field, navigate to the folder where you cloned the repository in step 1 and select it.<br />
6- On the **"Import Source"** put the path name for clonned sources, and click in **"Finish"**.<br />
7- You'll be able to see the project in the Project Explorer.</br />
8- To finish the installation, choose one of the links below and follow the provided instructions.

[TIBCO - Using Custom XPath Function at Design Time and Run Time.](https://docs.tibco.com/pub/activematrix_businessworks/6.9.0/doc/html/Default.htm#binding-palette/using-custom-xpath-f.htm?Highlight=custom%20functions) 

[TIBCO - Using External Custom XPath Function with TIBCO ActiveMatrix BusinessWorks Plug-in for Maven.](https://docs.tibco.com/pub/activematrix_businessworks/6.9.0/doc/html/Default.htm#app-dev-guide/external-custom-xpath-func-with-maven.htm?Highlight=custom%20functions)

## Uninstall

To uninstall it, please follow the instructions provided in the link below and select the **"Custom Functions TIBCO BusinessWorks 6/CE"** plugin when prompted."

[TIBCO - Deleting Custom XPath Functions.](https://docs.tibco.com/pub/activematrix_businessworks/6.9.0/doc/html/Default.htm#binding-palette/deleting-custom-xpat.htm?Highlight=custom%20functions)

## MIT Licence

Copyright (c) 2023 jgimenes

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), 
to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
