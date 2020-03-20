from visit import Visitor


class File():
    def __init__(self, name: str, size: int) -> None:
        self.__name = name
        self.__size = size

    def get_name(self) -> str:
        return self.__name

    def get_size(self) -> int:
        return self.__size

    def accept(self, visitor: Visitor) -> None:
        visitor.visit_file()
