from abc import ABCMeta, abstractmethod
from directory_entry import Directory
from file_enrty import File


class Visitor(object, metaclass=ABCMeta):

    @abstractmethod
    def visit_file(self, file: File) -> None:
        pass

    @abstractmethod
    def visit_directory(self, directory: Directory) -> None:
        pass


class ListVisitor(Visitor):

    def __init__(self):
        self.__currentdir = ""

    def visit_file(self, file: File) -> None:
        print(file)

    def visit_directory(self, directory: Directory) -> None:
        print(directory)
        savedir = self.__currentdir
        self.__currentdir = self.__currentdir + "/" + directory.get_name()
        it = directory.iterator()
        try:
            while(it.__next__()):
                entry = Directory(it.__next__())
                entry.accept(self)
        except StopIteration:
            pass
        self.__currentdir = savedir
