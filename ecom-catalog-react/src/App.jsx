import {use, useEffect, useState} from 'react'

import './App.css';
import ProductsList from "./ProductsList.jsx";
import CategoryFilter from "./CategoryFilter.jsx";

function App() {
const [products,setProduct]=useState([]);
const [categories,setCategory]=useState([])
const [selectedCategory,setSelectedCategory]=useState(null);
const [searchTerm,setSearchTerm]=useState("");
const [sortOrder,setSortOrder]=useState("asc");
useEffect(
    ()=>{
   fetch('http://localhost:8080/api/products/all')
       .then(response => response.json())
       .then(data => setProduct(data))
   fetch('http://localhost:8080/api/categories/all')
       .then(response =>response.json())
       .then(data => setCategory(data))
    },[]
)
    const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
    }
    const handleSortChange = (event) => {
        setSortOrder(event.target.value);
    }
    const handleCategorySelect = (categoryId) => {
        setSelectedCategory(categoryId ? Number(categoryId):null);
    }
    const filteredProducts=products
        .filter(
            product => {
                console.log("Product:", product.category?.id, "Selected:", selectedCategory);
                return (
                    (selectedCategory ? Number(product.category?.id) === selectedCategory : true)
                    &&
                product.name.toLowerCase().includes(searchTerm.toLowerCase())
                )
            }
        ).sort((a,b) => {
            if (sortOrder==="asc"){
                return a.price - b.price;
            }else{
                b.price - a.price;
            }
        })
    ;
  return (
   <div className="container">
       <h1 className="my-4">Product Catalog</h1>
       <div className="row align-items-center mb-4">
           <div className="col-md-3 col-sm-12 mb-12">
               <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>
           </div>
           <div className="col-md-5 col-sm-12 mb-2">
               <input
                   type="text"
                   placeholder="Search for a product"
                   className="form-control"
                   onChange={handleSearchChange}
               />
           </div>
           <div className="col-md-4 col-sm-12 mb-2">
               <select className="form-control" onChange={handleSortChange}>
                   <option value="asc">Sort by price: low to high</option>
                   <option value="desc">Sort by price: high to low</option>
               </select>
           </div>
       </div>
   <div>
       {filteredProducts.length?(
           //display products
           <ProductsList products={filteredProducts}/>
       ):(
           <p>no products found</p>
       )}
   </div>
   </div>
  )
}

export default App
