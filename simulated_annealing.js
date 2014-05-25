function city() {
    if (arguments.length == 0) {
        this.x = Math.floor(Math.random() * 200);
        this.y = Math.floor(Math.random() * 200);
    } 
    else {
        this.x = arguments[0];
        this.y = arguments[1];
    }
}
city.prototype.printC = function () {
    console.log(this.x + ' ' + this.y);
}
city.prototype.distanceTo = function (x) {
    var xD = Math.abs(this.x - x.x);
    var yD = Math.abs(this.y - x.y);
    return Math.sqrt((xD * xD) + (yD * yD));
}
cities = [];

function pathDistance(path) {
    var len = path.length;
    var res = 0;
    for(var i = 0; i < len - 1; i++) {
        res += path[i].distanceTo(path[i+1]);
    }
    return res;
}
function bestPathSa(current) {
    function probability(energy, newEnergy, temp) {
    return (newEnergy < energy) ? 1 : Math.exp((energy - newEnergy) / temp);
}
    var temp = 100000;
    var coolingRate = 0.003;
    while (temp > 1) {
        var newPath = current.slice(0);
        var t1 = Math.floor(newPath.length * Math.random());
        var t2 = Math.floor(newPath.length * Math.random());
        if(t1 != 0 && t2 != 0) {
            var c1 = newPath[t1];
            var c2 = newPath[t2];
            newPath[t2] = c1;
            newPath[t1] = c2;
        }
        var currentEnergy = pathDistance(current);
        var neighborEnergy = pathDistance(newPath);
        if(probability(currentEnergy, neighborEnergy, temp) > Math.random()) {
            best = newPath.slice(0);
        }
        temp *= 1 - coolingRate;
    }
    return best;
}

/* testing simulated annealing. */
for(var i = 0; i < 250; i++)
    cities.push(new city());

console.log("Default path  = " + pathDistance(cities));

var pathSa = bestPathSa(cities);
var lengthSa = pathDistance(pathSa);
for(var i = 0; i < pathSa.length; i++)
    console.log(pathSa[i].x + " " + pathSa[i].y);
console.log("Best path according to SA = " + lengthSa);
