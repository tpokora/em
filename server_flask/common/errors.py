class Error:
    def __init__(self, error_string):
        self.error = error_string

    def print(self):
        return self.__dict__

