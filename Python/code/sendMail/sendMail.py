import smtplib

host = 'smtp.qq.com'
port = 587
username = '3344707106'
password = 'engqcsbotbxqcica'
mailFrom = '3344707106@qq.com'
mailTo = 'irontomato.wei@foxmail.com'

print('Input mail to:')
t = input()
if len(t.strip()) > 0:
	mailTo = t
print("Input subject:")
subject = input()
print("Input content:")
content = input()

smtpObj = smtplib.SMTP(host,port)
smtpObj.ehlo()
smtpObj.starttls()
smtpObj.login(username,password)
smtpObj.sendmail(mailFrom,mailTo,'Subject: '+subject+'\n\n'+content)
smtpObj.quit()