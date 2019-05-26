#!/usr/bin/env python3

import requests
# from .configure import read_in_count, address_list

from timeit import timeit

# Configure this page

read_in_count = 1000

address_list = [
    ("http://localhost:8080/ladder", "GET"),
    ("http://localhost:8080/feature", "GET"),
    ("http://localhost:8080/json/ladder?start=start&end=end", "POST")
]


def main():

    def make_request():
        for req in address_list:
            if req[1] == "GET":
                requests.get(req[0])
            elif req[1] == "POST":
                requests.post(req[0])

    print("Average execution time: %f" %
          timeit(make_request, number=read_in_count))


if __name__ == "__main__":
    main()
