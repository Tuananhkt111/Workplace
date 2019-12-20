using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DTO
{
    public class ShoppingCart
    {
        public static bool AddCart(DTO.Accessory dto, Dictionary<string, DTO.Accessory> cart)
        {
            bool result = false;
            if (cart.ContainsKey(dto.AccId))
            {
                int quantityAdded = cart[dto.AccId].Quantity;
                int available = dto.AvailableQuantity;
                if (available != -1)
                {
                    int quantity = quantityAdded + dto.Quantity;
                    if (available >= quantity)
                    {
                        dto.Quantity = quantity;
                        cart[dto.AccId] = dto;
                        result = true;
                    }
                }
            }
            else
            {
                cart[dto.AccId] = dto;
                result = true;
            }
            return result;
        }
        public static bool RemoveCart(string id, Dictionary<string, DTO.Accessory> cart)
        {
            return cart.Remove(id);
        }
        public static double GetTotal(Dictionary<string, DTO.Accessory> cart)
        {
            double total = 0;
            foreach (DTO.Accessory item in cart.Values)
            {
                total += item.TotalPrice;
            }
            return total;
        }
        public static bool UpdateCart(string id, int quantity, Dictionary<string, DTO.Accessory> cart)
        {
            if (cart.ContainsKey(id))
            {
                cart[id].Quantity = quantity;
                return true;
            }
            return false;
        }
    }
}
