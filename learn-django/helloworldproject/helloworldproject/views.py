from django.http import HttpResponse
from django.views.generic import TemplateView


def hellow_world_function(request):
    responce = HttpResponse('hellow World')
    return responce

class HelloWorldView(TemplateView):
    template_name = 'hello.html'