
import requests
import configparser
config = configparser.ConfigParser()
config.read('config.ini')

API_KEY = config['mailgun'].get('API_KEY')
DOMAIN_NAME = config['mailgun'].get('DOMAIN_NAME')

def send_simple_message():
    with open('receiver_emails.txt', 'r') as file:
        message_text = file.readlines()


    response = requests.post(
        f"https://api.eu.mailgun.net/v3/{DOMAIN_NAME}/messages",
        auth=("api", API_KEY),
        data={
            "from": f"Excited User <bb@{DOMAIN_NAME}>",
            "to": message_text,
            "subject": "Hello",
            "text": "Testing some Mailgun awesomness!"
        }
    )
    print(response.text)
    return response

print(send_simple_message())


