用COM组件读写Excel
==================

首先假定电脑里已经安装了Excel

VS->解决方案资源管理器->引用->COM->Microsoft Excel xx.x Object Library

	// C# code
	using System;
	using Microsoft.Office.Interop.Excel;
	using ExcelApplication = Microsoft.Office.Interop.Excel.Application;
	
	namespace ConsoleCSharp
	{
	    class Program
	    {
	        static void Main(string[] args)
	        {
	            ExcelApplication app = new ExcelApplication();
	            Workbook wb = app.Workbooks.Open(@"D:\Test\test.xlsx");
	            Worksheet sheet = wb.Sheets["Sheet1"];
	            try
	            {
	                foreach (Range cell in sheet.UsedRange)
	                {
	                    if (cell != null && cell.Value2 != null)
	                    {
	                        Console.WriteLine(cell.Value2);
	                        cell.Value2 = cell.Value2 + "111";
	                    }
	                }
	            }
	            finally
	            {
	                wb.Save();
	                wb.Close();
	                app.Quit();
	            }
	            Console.ReadLine();
	        }
	    }
	}


附两个MSDN参考文档链接  

* [Application Interface (Microsoft.Office.Interop.Excel)](https://msdn.microsoft.com/zh-cn/library/microsoft.office.interop.excel.application(v=office.11).aspx "https://msdn.microsoft.com/zh-cn/library/microsoft.office.interop.excel.application(v=office.11).aspx")  
* [Microsoft.Office.Interop.Excel Namespace](https://msdn.microsoft.com/zh-cn/library/microsoft.office.interop.excel(v=office.11).aspx "https://msdn.microsoft.com/zh-cn/library/microsoft.office.interop.excel(v=office.11).aspx")