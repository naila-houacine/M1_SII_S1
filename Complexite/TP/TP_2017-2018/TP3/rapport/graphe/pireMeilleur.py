import numpy as np
import matplotlib.pyplot as plt
from scipy import interpolate

inputs = [ 1, 3, 5 , 7 , 10 , 15 , 20,30]
millieur = [2, 8 ,32 , 128, 1024 , 32768 , 1048576 , 1073741824]
def plot_algo_complexity( sorted):
	plt.title('Tour de Hanoi')
	plt.axis([min(inputs), max(inputs), min(sorted ) , max(sorted+0 )])
	sorted_line, = plt.plot(inputs, sorted, 'go')

	plt.figlegend(sorted_line, 'Complexité exacte' , 'upper right')
	plt.xlabel('nbr de disque')
	plt.ylabel('le temps d\'execution')






plot_algo_complexity(millieur )
plt.savefig('hanoiTH.png')
plt.show()
plt.clf()


