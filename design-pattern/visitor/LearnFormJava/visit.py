from abc import ABCMeta, abstractmethod
from directory_entry import Directory


class Visitor(object, metaclass=ABCMeta):
    @abstractmethod
    def visit_directory(self, directory: Directory) -> None:
        pass


class ListVisitor(Visitor):

    def __init__(self):
        self.__currentdir = ""

    def visit_directory(self, directory: Directory) -> None:
        savedir = self.__currentdir
        self.__currentdir = self.__currentdir + "/" + directory.get_name()
        # 追加されたディレクトリを表示
        print(self.__currentdir)
        it = iter(directory.get_dir())
        try:
            entry = next(it)
            while(entry):
                entry.accept(self)
                entry = next(it)
        except StopIteration:
            pass
        self.__currentdir = savedir
