from base64 import b64encode, b64decode
import base64
import time
list = '''BASE 64 ENCODE/DECODE


    ▄▄▄█████▓ ▒█████   ▒█████   ██▓    
    ▓  ██▒ ▓▒▒██▒  ██▒▒██▒  ██▒▓██▒    
    ▒ ▓██░ ▒░▒██░  ██▒▒██░  ██▒▒██░    
    ░ ▓██▓ ░ ▒██   ██░▒██   ██░▒██░    
      ▒██▒ ░ ░ ████▓▒░░ ████▓▒░░██████▒
      ▒ ░░   ░ ▒░▒░▒░ ░ ▒░▒░▒░ ░ ▒░▓  ░
        ░      ░ ▒ ▒░   ░ ▒ ▒░ ░ ░ ▒  ░
      ░      ░ ░ ░ ▒  ░ ░ ░ ▒    ░ ░   
                 ░ ░      ░ ░      ░  ░
                                     


E(e) - Encrypt, D(d) - Decrypt
Type "exit" for exit'''
print(list)
while True:
        cryptMode = input("[E]ncrypt|[D]ecrypt: ").upper()
        if cryptMode not in ['E','D']:
            if cryptMode=='EXIT':
                print("The program has ended")
                time.sleep(3)
                raise SystemExit
            print("Unknown mode, program has ended")
            time.sleep(3)
            raise SystemExit
        elif cryptMode == 'E':
            text1 = input('Enter the text to be encrypted:\n>')
            data1 = b64encode (str.encode (text1))
            data10 = str(data1, 'utf-8')
            print(data10)
            crypt=open("text_crypt.txt","w")
            crypt.write(data10)
            crypt.close()
            print("\n Result successfully saved to file 'text_crypt.txt'!")
        elif cryptMode == 'D':
            text2 = input('Enter text to be deciphered:\n>')
            data3 = b64decode (text2)
            data30 = str(data3, 'utf-8')
            print(data30)
            decrypt_w=open("text_decrypt.txt","w")
            decrypt_w.write(data30)
            decrypt_w.close()
            print("\n Result successfully saved to file'text_decrypt.txt'!")

