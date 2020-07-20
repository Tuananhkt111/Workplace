# import requests
import json
import time
import os
#from convert_template import read_json_from_file
import glob


def main():
    # Define input and output folder path
    input_folder = 'groundtruth_azure_json_Aeon_v3_0_0/'
    output_folder = 'output_testcases_v3_0_0/'

    # Template to generate test script
    testscript_file_path = 'postman_testscript_v2_0_0.txt'

    # list out all files from the groundtruth data
    array_files = [filename for filename in glob.glob(os.path.join(input_folder, '*.json'))]
    count = len(array_files)

    for idx, file_path in enumerate(array_files, 1):
        #file_name = file_path.split('/')[-1].replace('.json', '')
        file_name = os.path.splitext(os.path.basename(file_path))[0]
        print('=================processed %s in %s/%s' %(file_name, idx, count))
        data = read_json_from_file(file_path)
        items = data['receiptData']['items']
        if items == None:
            items = ''
        requestId = data['requestId']
        status = data['status']
        numberOfItems = data['receiptData']['numberOfItems']
        if numberOfItems == None:
            numberOfItems = ''
        mallName = data['receiptData']['mallName']
        if mallName == None:
            mallName = ''
        storeName = data['receiptData']['storeName']
        if storeName == None:
            storeName = ''
        receiptId = data['receiptData']['receiptId']
        if receiptId == None:
            receiptId = ''
        totalAmount = data['receiptData']['totalAmount']
        if totalAmount == None:
            totalAmount = ''
        seller = data['receiptData']['seller']
        if seller == None:
            seller = ''
        transactionDateTime = data['receiptData']['transactionDateTime']
        if transactionDateTime == None:
            transactionDateTime = ''
        
        with open(testscript_file_path) as template_file:
            template_file = open(testscript_file_path, "r")
            testcase_template = template_file.read()
            testcase_template = testcase_template.replace("EXPECTED_NUMBER_OF_ITEMS", str(numberOfItems))
            testcase_template = testcase_template.replace("EXPECTED_REQUEST_ID", requestId)
            testcase_template = testcase_template.replace("EXPECTED_STATUS", status)
            testcase_template = testcase_template.replace("EXPECTED_MALL_NAME", mallName)
            testcase_template = testcase_template.replace("EXPECTED_RECEIPT_ID", receiptId)
            testcase_template = testcase_template.replace("EXPECTED_SELLER", seller)
            testcase_template = testcase_template.replace("EXPECTED_STORE_NAME", storeName)
            testcase_template = testcase_template.replace("EXPECTED_RECEIPT_TOTAL_AMOUNT", totalAmount)
            testcase_template = testcase_template.replace("EXPECTED_RECEIPT_TRANSACTION_DATE_TIME", transactionDateTime)
            testcase_template = testcase_template.replace("EXPECTED_RECEIPT_PRODUCT_ITEMS", json.dumps(items))

            with open(os.path.join(output_folder, file_name+'.txt'), "w") as data_file:
                data_file.write(testcase_template)
                data_file.close()

def read_json_from_file(file_path):
    with open(file_path) as json_file:
        data = json.load(json_file)
        return data
    
if __name__ == "__main__":
    main()
