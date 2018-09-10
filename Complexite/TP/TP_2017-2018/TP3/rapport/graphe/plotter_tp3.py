import numpy as np
import matplotlib.pyplot as plt


def plot_line(x, y):
	plt.plot(np.unique(x), np.poly1d(np.polyfit(x, y, 2))(np.unique(x)))

numbers = [50000 , 100000 , 200000 , 400000 , 800000 , 1600000 , 3200000 , 6400000 , 12800000 , 25600000 , 1024000000 ]


 partie1_millieur_cas = 2 * np.array(numbers) * np.array(numbers) + 7 * np.array(numbers) - 5
 partie1_pire_cas = 3.5 * np.array(numbers) * np.array(numbers) + 8.5 * np.array(numbers) - 11

plt.title('Pire cas VS Meilleur cas')
plt.axis([0.00, 65000000, 0.00, 80000000000000000])
line1, = plt.plot(numbers, partie1_millieur_cas, 'go')
line2, = plt.plot(numbers, partie1_pire_cas, 'ro')
plot_line(numbers, partie1_millieur_cas)
plot_line(numbers, partie1_pire_cas)
plt.figlegend((line1, line2), ('meilleur', 'pire'), 'upper left')
plt.xlabel('taille du tableau')
plt.ylabel('nbr inst ele')
plt.savefig('Pire_cas_VS_Meilleur_cas.png')
plt.clf()
#plt.show()


partie1 = [4.813000, 19.649000, 79.942000, 318.696000, 1274.784000, 5736.528000, 22946.112000, 94996.908000, 436985.756900 , 1747943.028000, 7201525.274000]

plt.title('Tableau dans le bon ordre')
plt.axis([50000, 1024000000, 0, 8000000])
plt.plot(numbers, partie1, 'bo')
plot_line(numbers, partie1)
plt.xlabel('Taille du tableau')
plt.ylabel('temps')
plt.savefig('ordre.png')
plt.clf()
#plt.show()


partie2 = [5.308000, 21.059000, 87.593000, 342.122000, 1368.488000, 5446.582000, 22330.988000, 93790.146170,373284.781800, 1530467.605000, 6106565.745000]

plt.title('Tableau dans l\'ordre inverse')
plt.axis([50000, 1024000000, 0, 8000000])
plt.plot(numbers, partie2, 'go')
plot_line(numbers, partie2)
plt.xlabel('Taille du tableau')
plt.ylabel('temps')
plt.savefig('inverse.png')
plt.clf()
#plt.show()




partie3 = [5.025000, 20.328000, 81.150000, 292.308000, 1169.232000, 4817.235840, 19172.59864, 76690.394570, 322099.657200, 1285177.632000, 5654781.582000]

plt.title('Tableau dans aléatoire')
plt.axis([50000, 1024000000, 0, 8000000])
plt.plot(numbers, partie3, 'ro')
plot_line(numbers, partie3)
plt.xlabel('Taille du tableau')
plt.ylabel('temps')
plt.savefig('aleatoire.png')
plt.clf()
#plt.show()
