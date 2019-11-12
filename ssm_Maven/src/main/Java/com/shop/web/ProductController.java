package com.shop.web;

import com.shop.dao.ProductDao;
import com.shop.domian.Product;
import com.shop.domian.ProductOrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/item")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/product")
    public ModelAndView getProduct(){
        List<Product> productList = productDao.getProductList();
        //要把list数据封装到ModeAndView
        ModelAndView modelAndView=new ModelAndView();
        //封装数据
        modelAndView.addObject("productList",productList);
        //封装逻辑视图名
        modelAndView.setViewName("productList");
        return modelAndView;
    }

    @RequestMapping("/itemEdit.action")
    public ModelAndView getProductById(Integer id){
        System.out.println("id:"+id);
        Product productById = productDao.getProductById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("item",productById);
        mv.setViewName("productItem");
        return mv;
    }

    @RequestMapping("/updateitem.action")
    public ModelAndView updateproduct(Product product, MultipartFile pictureFile){
       // product.setCreatetime(new Date());
        //获取上传过来的文件名称
        String filename = pictureFile.getOriginalFilename();
        //限制文件类型,通过后缀名进行判断(基本的处理,不保险)
        //文件的取名,唯一,UUID生成一个唯一的图片名称mei.nv.jpg
        String newFileName=(UUID.randomUUID().toString()+ filename.substring(filename.lastIndexOf("."))).replace("-","");

        //执行上传操作
        //参数File：表示要把文件上传到服务器的哪个地方
        File file=new File("G:\\testimg\\img\\"+newFileName);
        if (!file.exists())//判断文件夹是否存在
        {
            file.mkdirs();
        }
        try {
            pictureFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = productDao.updateProduct(product);

        if (i>0){
            return getProduct();
        }

        return null;
    }

    @RequestMapping("/deleteProduct.action")
    public ModelAndView deleteProduct(ProductOrUser pu){
        //获取到每个id
        System.out.println(pu.getIds());


        return getProduct();
    }

    @RequestMapping("/updateProductList.action")
    public ModelAndView updateProductList(ProductOrUser pu){
        //获取到每个id
        System.out.println(pu.getProductList());


        return null;
    }

    @RequestMapping("/plhuoquList")
    public ModelAndView getProductList(){
        List<Product> productList = productDao.getProductList();
        //要把list数据封装到ModeAndView
        ModelAndView modelAndView=new ModelAndView();
        //封装数据
        modelAndView.addObject("plhuoquList",productList);
        //封装逻辑视图名
        modelAndView.setViewName("plhuoquList");
        return modelAndView;
    }
}
