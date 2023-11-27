const detailSanPhamAPI =
    "http://localhost:8080/san-pham/san-pham-detail/id-san-pham=";
const getPhanHoiAPI = "http://localhost:8080/phan-hoi/get/idSanPham=";
myApp.controller(
    "TrangChiTietSanPhamController",
    function (
        $scope,
        $rootScope,
        $http,
        $routeParams,
        checkOutDataService,
        $location,
        $window
    ) {
        $scope.idSp = $routeParams.idSp;
        $scope.chiTietSanPham;
        $scope.sanPhamDetail;
        $scope.isFirstRun = 0;
        $scope.soLuong = 1;
        $scope.moreInfo = "active";
        $scope.dataSheet = "";
        $scope.review = "";

        $scope.phanHoi = [];
        $scope.pageSize = 2;
        $scope.currentPage = 1;
        $scope.maxPagesToShow = 2;
        $scope.totalPages;
        $scope.check;
        $scope.Items = [];
        $rootScope.currentDate = new Date().toISOString();
        $scope.selectImage = "";

        var setMauSac = new Set();
        var setKichCo = new Set();
        var setChatLieu = new Set();
        var setCauTrucKhuy = new Set();


        $scope.setAvaiableMauSac = new Set();
        $scope.setAvaiableKichCo = new Set();
        $scope.setAvaiableChatLieu = new Set();
        $scope.setAvaiableCauTrucKhuy = new Set();


        $scope.selectedKC;
        $scope.selectedMS;
        $scope.selectedCL;
        $scope.selectedCTK;

        $scope.getDetailSanPham = function (idSp) {
            $http
                .get(detailSanPhamAPI + idSp)
                .then(function (response) {
                    $scope.sanPhamDetail = response.data;
                    $scope.chiTietSanPham = $scope.sanPhamDetail.listChiTietSanPham[0];
                    $scope.selectedMS = $scope.chiTietSanPham.mauSac.tenMauSac;
                    $scope.selectedKC = $scope.chiTietSanPham.kichCo.tenKichCo;
                    $scope.selectedCL = $scope.chiTietSanPham.chatLieu.tenChatLieu;
                    $scope.selectedCTK = $scope.chiTietSanPham.cauTrucKhuy.tenCauTrucKhuy;
                    getSettingAttributeSp($scope.sanPhamDetail.listChiTietSanPham);
                    $scope.PhanHoiAPI();
                    $rootScope.currentDate = new Date().toISOString();
                    $scope.selectImage = $scope.sanPhamDetail.listAnhSanPham[0].link;
                    getAvailabelAttribute(
                        $scope.selectedKC,
                        $scope.selectedMS,
                        $scope.selectedCL,
                        $scope.selectedCTK,
                    );
                })
                .catch(function (error) {
                    console.log(error);
                });
        };

        $scope.changeImage = function (item) {
            $scope.selectImage = item.link;
        }
        $scope.tang = function () {
            $scope.soLuong = $scope.soLuong + 1;
        };
        $scope.giam = function () {
            if ($scope.soLuong == 1) {
                alert("Đã giảm tối thiểu");
                return;
            }
            $scope.soLuong = $scope.soLuong - 1;
        };


        $scope.getDetailSanPham($scope.idSp);
        var getSettingAttributeSp = function (listChiTietSanPham) {
            listChiTietSanPham.forEach((ctsp) => {
                setMauSac.add(ctsp.mauSac.tenMauSac);
                setKichCo.add(ctsp.kichCo.tenKichCo);
                setChatLieu.add(ctsp.chatLieu.tenChatLieu);
                setCauTrucKhuy.add(ctsp.cauTrucKhuy.tenCauTrucKhuy);
            });
            $scope.listMauSac = Array.from(setMauSac);
            $scope.listKichCo = Array.from(setKichCo);
            $scope.listChatLieu = Array.from(setChatLieu);
            $scope.listCauTrucKhuy = Array.from(setCauTrucKhuy);
        };

        $scope.$watchGroup(
            ["selectedMS", "selectedKC", "selectedCL","selectedCTK",],
            function (newValues, oldValues) {
                $scope.soLuong = 1;
                $scope.isFirstRun++;
                if ($scope.isFirstRun <= 1) {
                    return;
                }
                //kichco
                if (newValues[0] !== oldValues[0]) {
                    $scope.chiTietSanPham =
                        $scope.sanPhamDetail.listChiTietSanPham.filter(function (item) {
                            return item.kichCo.tenKichCo == $scope.selectedKC;
                        })[0];
                    resetSelectedValue();
                }
                //MauSac
                if (newValues[1] !== oldValues[1]) {
                    $scope.chiTietSanPham =
                        $scope.sanPhamDetail.listChiTietSanPham.filter(function (item) {
                            return (
                                item.mauSac.tenMauSac == $scope.selectedMS &&
                                item.kichCo.tenKichCo == $scope.selectedKC
                            );
                        })[0];
                    resetSelectedValue();
                }
                //chatLieu
                if (newValues[1] !== oldValues[1]) {
                    $scope.chiTietSanPham =
                        $scope.sanPhamDetail.listChiTietSanPham.filter(function (item) {
                            return (
                                item.mauSac.tenMauSac == $scope.selectedMS &&
                                item.kichCo.tenKichCo == $scope.selectedKC &&
                                item.chatLieu.tenChatLieu == $scope.selectedKC
                            );
                        })[0];
                    resetSelectedValue();
                }
                //cautruckhuy
                if (newValues[1] !== oldValues[1]) {
                    $scope.chiTietSanPham =
                        $scope.sanPhamDetail.listChiTietSanPham.filter(function (item) {
                            return (
                                item.mauSac.tenMauSac == $scope.selectedMS &&
                                item.kichCo.tenKichCo == $scope.selectedKC &&
                                item.chatLieu.tenChatLieu == $scope.selectedKC&&
                                item.cauTrucKhuy.tenCauTrucKhuy == $scope.selectedCTK
                            );
                        })[0];
                    resetSelectedValue();
                }
                getAvailabelAttribute();
                $rootScope.currentDate = new Date().toISOString();
                $scope.PhanHoiAPI();
            }
        );

        var resetSelectedValue = function () {
            $scope.selectedMS = $scope.chiTietSanPham.mauSac.tenMauSac;
            $scope.selectedKC = $scope.chiTietSanPham.kichCo.tenKichCo;
            $scope.selectedCL = $scope.chiTietSanPham.chatLieu.tenChatLieu;
            $scope.selectedCTK = $scope.chiTietSanPham.cauTrucKhuy.tenCauTrucKhuy;
        };

        var getAvailabelAttribute = function () {
            // $scope.setAvaiableKichCo = new Set();
            $scope.setAvaiableMauSac = new Set();
            $scope.setAvaiableChatLieu = new Set();
            $scope.setAvaiableCauTrucKhuy = new Set();

            //Filter Set Mau Sac
            $scope.sanPhamDetail.listChiTietSanPham
                .filter(function (item) {
                    return item.kichCo.tenKichCo == $scope.selectedKC;
                })
                .forEach(function (item) {
                    $scope.setAvaiableMauSac.add(item.mauSac.tenMauSac);
                });
            // Filter Set chát liệu
            $scope.sanPhamDetail.listChiTietSanPham
                .filter(function (item) {
                    return (
                        item.kichCo.tenKichCo == $scope.selectedKC &&
                        item.mauSac.tenMauSac == $scope.selectedMS
                    );
                })
                .forEach(function (item) {
                    $scope.setAvaiableChatLieu.add(item.chatLieu.tenChatLieu);
                });
            // Filter Set cautruckhuy
            $scope.sanPhamDetail.listChiTietSanPham
                .filter(function (item) {
                    return (
                        item.kichCo.tenKichCo == $scope.selectedKC &&
                        item.mauSac.tenMauSac == $scope.selectedMS &&
                        item.chatLieu.tenChatLieu == $scope.selectedCL
                    );
                })
                .forEach(function (item) {
                    $scope.setAvaiableCauTrucKhuy.add(item.cauTrucKhuy.tenCauTrucKhuy);
                });
            //Filter Set Kich Co
            // $scope.sanPhamDetail.listChiTietSanPham
            //     .filter(function (item) {
            //         return (
            //             item.kichCo.tenKichCo == $scope.selectedKC &&
            //             item.mauSac.tenMauSac == $scope.selectedMS &&
            //             item.cauTrucKhuy.tenCauTrucKhuy == $scope.selectedCTK &&
            //             item.chatLieu.tenChatLieu == $scope.selectedCL
            //         );
            //     })
            //     .forEach(function (item) {
            //         $scope.setAvaiableKichCo.add(item.kichCo.tenKichCo);
            //     });
        };
        let currentUser = JSON.parse(localStorage.getItem("currentUser"));
        var giaSanPham = 0;
        $scope.getGia = function () {
            if ($scope.chiTietSanPham.khuyenMai == null) {
                return giaSanPham = $scope.chiTietSanPham.giaSanPham;
            } else {
                if ($scope.chiTietSanPham.khuyenMai.enabled == false) {
                    return giaSanPham = $scope.chiTietSanPham.giaSanPham;
                } else {
                    if ($rootScope.currentDate < $scope.chiTietSanPham.khuyenMai.ngayKetThuc.toString()) {
                        if ($rootScope.currentDate < $scope.chiTietSanPham.khuyenMai.ngayBatDau.toString()) {
                            return giaSanPham = $scope.chiTietSanPham.giaSanPham;
                        } else {
                            return giaSanPham = $scope.chiTietSanPham.giaSanPham - $scope.chiTietSanPham.giaSanPham * $scope.chiTietSanPham.khuyenMai.chietKhau / 100;
                        }
                    } else {
                        return giaSanPham = $scope.chiTietSanPham.giaSanPham;


                    }
                }
            }
        }

        $scope.changeTab = function (tab) {

            $scope.moreInfo = "";
            $scope.dataSheet = "";
            $scope.review = "";
            if (tab == 1) {
                $scope.moreInfo = "active";
            } else if (tab == 2) {
                $scope.dataSheet = "active";
            } else {
                $scope.review = "active";
                $scope.PhanHoiAPI();

            }

        }

        $scope.$watchGroup(["phanHoi"], function () {
            $scope.currentPage = 1;
            $scope.pages = [];
            var startPage = Math.max(1, $scope.currentPage - $scope.maxPagesToShow);
            var endPage = Math.min(
                $scope.totalPages,
                $scope.currentPage + $scope.maxPagesToShow
            );
            for (var i = startPage; i <= endPage; i++) {
                $scope.pages.push(i);
            }
            var startIndex = ($scope.currentPage - 1) * $scope.pageSize;
            var endIndex = startIndex + $scope.pageSize;
            $scope.Items = $scope.phanHoi.slice(startIndex, endIndex);


        });
        $scope.addToCart = function () {
            if (currentUser) {
                var item = {
                    idChiTietSanPham: $scope.chiTietSanPham.idChiTietSanPham,
                    soLuong: $scope.soLuong,
                    idKhachHang: currentUser.idKhachHang,
                    giaSanPham: $scope.getGia()
                };

                if ($scope.chiTietSanPham) {
                    $http
                        .post(`/api/giohang/addToCart`, item)
                        .then((resp) => {
                            // console.log(resp,"resssssssssssssssss")
                            if (resp.data == '') {
                                Swal.fire({
                                    icon: "warning",
                                    title: "Thông báo !",
                                    text: "Quá số lượng sản phẩm!",
                                    timer: 5600,
                                });
                                return;
                            } else {
                                Swal.fire({
                                    icon: "success",
                                    title: "Thành công",
                                    text: "Đã thêm vào giỏ hàng!",
                                    timer: 3600,
                                });
                                setTimeout(function () {
                                    $window.location.reload();
                                }, 2600)
                            }
                        })
                        .catch((error) => {
                            alert("Loi roi", error);
                        });
                } else {
                    alert("Khong có sp");
                    return;
                }
            } else {
                Swal.fire({
                    icon: "warning",
                    title: "Chưa đăng nhập",
                    text: "Bạn hãy đăng nhập !",
                    timer: 5600,
                });
                $window.location.href = '#login';
            }
        };
        $scope.buyNow = () => {
            checkOutDataService.setData([
                {
                    // idChiTietSanPham: $scope.chiTietSanPham.idChiTietSanPham,
                    giaBan: $scope.getGia(),
                    idChiTietSanPham: $scope.chiTietSanPham.idChiTietSanPham,
                    soLuong: $scope.soLuong,
                    chiTietSanPham: $scope.chiTietSanPham
                },
            ]);
            Swal.fire({
                title: 'Xác nhận mua sản phẩm ?',
                text: "Bạn hãy xác nhận mua sản phẩm ",
                icon: 'info',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Xác nhận'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire({
                        title: 'Loading',
                        onOpen: () => {
                            Swal.showLoading();
                        },
                        timer: 2000
                    })
                    setTimeout(function () {
                        $window.location.href = "#checkout"
                    }, 1900)
                }
            })


        };

        $scope.PhanHoiAPI = function () {
            var idChiTietSanPham = $scope.chiTietSanPham.idChiTietSanPham;

            // const idSP = $scope.idSP;
            $http
                .get(`phan-hoi/get/${idChiTietSanPham}`)
                .then(function (response) {
                    $scope.phanHoi = response.data;
                    $scope.totalPages = Math.ceil(
                        $scope.phanHoi.length / $scope.pageSize
                    );
                })

                .catch(function (error) {
                    console.log(error);
                });
        };

        $scope.changePage = function (page) {
            $scope.pages = [];
            $scope.currentPage = page;
            var startPage = Math.max(1, $scope.currentPage - $scope.maxPagesToShow);
            var endPage = Math.min(
                $scope.totalPages,
                $scope.currentPage + $scope.maxPagesToShow
            );
            var startIndex = ($scope.currentPage - 1) * $scope.pageSize;
            var endIndex = startIndex + $scope.pageSize;
            for (var i = startPage; i <= endPage; i++) {
                $scope.pages.push(i);
            }
            $scope.Items = $scope.phanHoi.slice(startIndex, endIndex);
            $scope.checkFirstLastPage();
        };

        $scope.previousPage = function () {
            $scope.pages = [];
            if ($scope.currentPage > 1) {
                $scope.currentPage--;
                var startPage = Math.max(1, $scope.currentPage - $scope.maxPagesToShow);
                var endPage = Math.min(
                    $scope.totalPages,
                    $scope.currentPage + $scope.maxPagesToShow
                );
                var startIndex = ($scope.currentPage - 1) * $scope.pageSize;
                var endIndex = startIndex + $scope.pageSize;
                for (var i = startPage; i <= endPage; i++) {
                    $scope.pages.push(i);
                }
                $scope.Items = $scope.phanHoi.slice(startIndex, endIndex);
                $scope.checkFirstLastPage();
            }
        };

        $scope.nextPage = function () {
            $scope.pages = [];
            if ($scope.currentPage < $scope.totalPages) {
                $scope.currentPage++;
                var startPage = Math.max(1, $scope.currentPage - $scope.maxPagesToShow);
                var endPage = Math.min(
                    $scope.totalPages,
                    $scope.currentPage + $scope.maxPagesToShow
                );
                var startIndex = ($scope.currentPage - 1) * $scope.pageSize;
                var endIndex = startIndex + $scope.pageSize;
                for (var i = startPage; i <= endPage; i++) {
                    $scope.pages.push(i);
                }
                $scope.Items = $scope.phanHoi.slice(startIndex, endIndex);
                $scope.checkFirstLastPage();
            }
        };

        $scope.checkFirstLastPage = function () {
            console.log($scope.currentPage);
            if ($scope.currentPage <= 1) {
                $scope.isFirstPage = true;
            } else {
                $scope.isFirstPage = false;
            }
            if ($scope.currentPage >= $scope.totalPages) {
                $scope.isLastPage = true;
            } else {
                $scope.isLastPage = false;
            }
        }

        $scope.rating = 0;
        $scope.ratings = {
            current: -1,
            max: 5,
        };
        $scope.sendRate = function () {
            if (currentUser) {
                $scope.phanhoirequest = {
                    danhGia: $scope.ratings.current,
                    noiDungPhanHoi: angular.element("#noiDungPhanHoi").val(),
                    idChiTietSanPham: $scope.chiTietSanPham.idChiTietSanPham,
                    idKhachHang: currentUser.idKhachHang,
                };
                console.log($scope.phanhoirequest);
                $http
                    .post(`/api/phan-hoi/add`, $scope.phanhoirequest)
                    .then((resp) => {
                        console.log(resp);
                        alert("Them thanh cong");
                        $scope.PhanHoiAPI();
                        // $scope.checkPhanHoiAPI();

                        // $window.location.reload();
                    })
                    .catch((error) => {
                        alert("Loi roi", error);
                    });
            } else {
                Swal.fire({
                    icon: "warning",
                    title: "Bạn chưa đăng nhập !",
                    text: "Hãy đăng nhập để tiếp tục shopping!",
                    showConfirmButton: true,
                    closeOnClickOutside: true,
                    timer: 5600,
                });
                $window.location.href = '#login';
            }
        };
    }
);


myApp.directive("starRating", function () {
    return {
        template:
            '<ul class="rating" >' +
            '<li ng-repeat="star in stars" ng-class="star">' +
            "\u2605" +
            "</li>" +
            "</ul>",
        scope: {
            ratingValue: "=",
            max: "=",
            onRatingSelected: "&",
        },
        link: function (scope, elem, attrs) {
            var updateStars = function () {
                scope.stars = [];
                for (var i = 0; i < scope.max; i++) {
                    scope.stars.push({
                        filled: i < scope.ratingValue,
                    });
                }
            };
            scope.$watch("ratingValue", function (newVal) {
                if (newVal) {
                    updateStars();
                }
            });
        },
    };
});

