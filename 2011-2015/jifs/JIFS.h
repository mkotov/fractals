// Matvej Kotov, 2014
// http://fractalworld.xaoc.ru/

#ifndef _JIFS_H_
#define _JIFS_H_

#include <vector>
#include <vcl.h>

#include "ANN/ANN.h" // ANN can be downloaded here http://www.cs.umd.edu/~mount/ANN/

namespace ru_xaoc_fractalworld
{

class Point
{
private:
    double x_;
    double y_;

public:
    Point(const double x, const double y);
    double x() const;
    double y() const;
    double sqrdLen() const;
};


class AffineTransform
{
private:
    double a_;
    double b_;
    double c_;
    double d_;
    double e_;
    double f_;

public:
    AffineTransform(const double a, const double b, const double c,
            const double d, const double e, const double f);
    Point apply(const Point &z) const;
    Point applyInvert(const Point &z) const;
};


class Points
{
private:
    std::vector<std::pair<Point, size_t> > points_;

public:
    explicit Points(const std::vector<std::pair<Point, size_t> > &points);
    AffineTransform calcStretchTransform(
                const size_t width, const size_t height,
                const size_t border = 40) const;
    void draw(TCanvas *canvas, const AffineTransform &stretchTransform) const;
    Point getPoint(const size_t i) const;
    size_t getClass(const size_t i) const;
    size_t size() const;
};


class Colorer
{
private:
    size_t maxColorNum_;

public:
    explicit Colorer(const size_t maxColorNum);
    TColor getColor(const size_t n) const;
};


class IFS
{
private:
     std::vector<AffineTransform> ts_;
     std::vector<double> ps_;

public:
    IFS(const std::vector<AffineTransform> &ts, const std::vector<double> &ps);
    Point apply(const size_t i, const Point &z) const;
    Point applyInvert(const size_t i, const Point &z) const;
    size_t getRandom() const;

    Points apply(const size_t maxIterNum = 1000, const size_t skipIterNum = 50) const;
    void drawR(TCanvas *canvas, const size_t width, const size_t height,
            const size_t maxIterNum = 1000, const size_t skipIterNum = 50) const;
    void drawJ(TCanvas *canvas, const size_t width, const size_t height,
            const Colorer &colorer,
            const size_t maxIterNum = 16, const size_t sqrdBound = 16) const;
    void drawSplitter(TCanvas *canvas, const size_t width, const size_t height,
            const Colorer &colorer) const;

};


class NNClassifier
{
private:
    ANNpointArray dataPts_;
    ANNpoint queryPt_;
    ANNidxArray nnIdx_;
    ANNdistArray dists_;
    ANNkd_tree *kdTree_;

    NNClassifier(const NNClassifier &); /* = delete */
    NNClassifier operator=(const NNClassifier &); /* = delete */

public:
    explicit NNClassifier(const Points &points);
    size_t getIndex(const Point &z);
    ~NNClassifier();
};


class Splitter
{
private:
    mutable NNClassifier classifier_;
    Points points_;

public:
    explicit Splitter(const Points &points);
    size_t getClass(const Point &z) const;
    void draw(TCanvas *canvas, const size_t width, const size_t height,
            const Colorer &colorer) const;
};

} // namespace ru_xaoc_fractalworld

#endif