import numpy as np
import matplotlib.pyplot as plt
from scipy import interpolate

inputs = [ 1, 3, 5 , 7 ,8, 10 , 12 , 15 , 20]
m = [2, 8 ,32 , 128,256 , 1024 , 4096 , 32768 , 1048576 ]

def plot_algo_complexity(name, mm, inversed, random):
	plt.title(name)
	plt.axis([min(inputs), max(inputs), min(mm+ inversed + random), max(mm + inversed + random)])
	sorted_line, = plt.plot(inputs, mm, 'go')
	inversed_line, = plt.plot(inputs, inversed, 'ro')
	random_line, = plt.plot(inputs, random, 'bo')
	plt.figlegend((sorted_line, inversed_line, random_line), ('tableau trie dans le bon ordre', 'tableau non trie (aleatoire)' ,'tableau trie en ordre inverse'), 'upper right')
	plt.xlabel('la taille du tableau')
	plt.ylabel('le temps d\'execution')

name = 'tri par selection'
inversed_results = [0,0,0,0,0,0,0,0,0]
sorted_results = [0,0,0,0,0,0,0,0,0]
random_results = [0,0,0,0,0,0,0,0,0]

plot_algo_complexity(name, m, inversed_results, random_results)
plt.savefig(name + '.png')
plt.show()
plt.clf()
