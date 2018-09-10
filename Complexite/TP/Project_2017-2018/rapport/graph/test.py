import numpy as np
import matplotlib.pyplot as plt
from scipy import interpolate
from math import log

plt.figure(figsize=(10, 7))


def plot_theorique(name, pireF):
	plt.title(name)
	axis = np.arange(1, 64, 1)
	pire = np.array([pireF(x) for x in axis])

	
	plt.axis([min(axis), max(axis), min(pire), max(pire)])
	pire_line,  = plt.plot(axis, pire, 'g-')
	
	plt.figlegend((pire_line), ('Complexité exacte'), 'upper right')
	plt.xlabel('le nombre de disque')
	plt.ylabel('le temps d\'execution')
	#plt.savefig(name + '_teorique.png')
	plt.show()
	plt.clf()


name = 'Hanoi'
plot_theorique(name, lambda x: x**2 )

