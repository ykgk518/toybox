from typing import TypeVar, List

Visitor = TypeVar('Vistor')
Directory = TypeVar('Directory')


class Directory():

    def __init__(self, name: str) -> None:
        self.__name = name
        self.__dir: List[Directory] = []

    def get_name(self) -> str:
        return self.__name

    def get_dir(self) -> List:
        return self.__dir

    def add(self, directory: Directory) -> Directory:
        self.__dir.append(directory)
        return self

    def accept(self, visitor: Visitor) -> None:
        visitor.visit_directory(self)
