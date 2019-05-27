#!/usr/bin/env python3

import requests
# from .configure import read_in_count, address_list

from timeit import timeit
from random import random
# Configure this page

MAX_INT = 21875

read_in_count = 1000

address = "http://localhost:8080/addup"


def start_perform():

    def make_request():
        requests.get(address, data={
            'number': int(random() * MAX_INT),
            'plus': int(random() * MAX_INT),
        })

    print("Average execution time: %f" %
          timeit(make_request, number=read_in_count))


if __name__ == "__main__":
    start_perform()
