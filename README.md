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
- [Install](#install)
  - [Basic](#basic)
- [Uninstall](#uninstall)
  - [Windows & Linux](#windows-linux)
  - [MacOS](#macos) 
- [MIT Licence](#licence)


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
    
      ##### Examples:

      **Input:** dt:epoch-to-human-readable("1679332277")<br />
      **Return:** 2023-03-20T14:11:17.017-03:00

      **Input:** dt:epoch-to-human-readable(xsd:string(tib:timestamp()))<br />
      **Return:** 2023-03-20T14:39:40.040-03:00
      
  - #### extract-day-of-year() 
    **Description:** Retrieves the day number within a year for a given date.<br />
    **Template:** extract-day-of-year(<< date >>)<br />
    **Return Type:** integer
    
      ##### Example:

      **Input:** dt:extract-day-of-year("2023-12-31")<br />
      **Return:** 365

  - #### extract-week-of-year() 
    **Description:** Retrieves the week number within a year for a given date.<br />
    **Template:** extract-week-of-year(<< date >>)<br />
    **Return Type:** integer
    
      ##### Example:

      **Input:** dt:extract-week-of-year("2023-12-31")<br />
      **Return:** 53

  - #### epoch-to-human-readable() 
    **Description:** Convert a readable date format to an Epoch timestamp.<br />
    **Template:** human-readable-to-epoch(<< datetime >>)<br />
    **Return Type:** string
    
      ##### Examples:

      **Input:** dt:human-readable-to-epoch("2023-03-20T14:11:17.017-03:00")<br />
      **Return:** 1679332277

      **Input:** dt:human-readable-to-epoch(xsd:string(current-dateTime()))<br />
      **Return:** 1679336875

- ### Custom String Functions

## Install
...

## Uninstall

## MIT Licence

Copyright (c) 2023 jgimenes

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), 
to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
